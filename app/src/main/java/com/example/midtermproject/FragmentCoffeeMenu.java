package com.example.midtermproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.midtermproject.Adapter.AdapterCoffee;
import com.example.midtermproject.Adapter.AdapterLoyaltyCard;
import com.example.midtermproject.MVVM.CoffeeViewModel;
import com.example.midtermproject.Model.ModelCoffee;
import com.example.midtermproject.Model.ModelRewardHistory;
import com.example.midtermproject.Model.ModelUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class FragmentCoffeeMenu extends Fragment implements AdapterCoffee.GetOnCoffee{

    FirebaseFirestore firebaseFirestore;
    AdapterCoffee mAdapter;
    AdapterLoyaltyCard mAdapterLoyaltyCard;
    RecyclerView recyclerView;
    RecyclerView recyclerViewLoyaltyCard;
    CoffeeViewModel viewModel;
    TextView userName;
    TextView numLoyaltyCard;
    ModelUser modelUser = ModelUser.getInstance();
    MainActivity mMainActivity;
    View mView;

    LinearLayout layoutLoyaltyCard;
    ImageButton btnSwitchProfile;
    ImageButton btnSwitchCart;

    public FragmentCoffeeMenu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_coffee_menu, container, false);
        mMainActivity = (MainActivity) getActivity();
        userName = (TextView) mView.findViewById(R.id.userName);
        numLoyaltyCard = mView.findViewById(R.id.textNumberLoyaltyCard);
        recyclerViewLoyaltyCard = mView.findViewById(R.id.recLoyatyCardMenu);
        layoutLoyaltyCard = mView.findViewById(R.id.layoutLoyaltyCardMenu);

        numLoyaltyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppController.numberLoyaltyCard == 8)
                {
                    AppController.numberLoyaltyCard = 0;
                    ModelRewardHistory modelRewardHistory = new ModelRewardHistory(4000, "Loyalty Card");
                    AppController.listModelRewardHistory.add(modelRewardHistory);
                    Toast.makeText(mMainActivity, "Receive 4000 redeem points", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnSwitchCart = mView.findViewById(R.id.cart);
        btnSwitchCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CartActivity.class);
                getActivity().startActivity(intent);
            }
        });
;

        //Set layout for Recycler view
        recyclerView = mView.findViewById(R.id.recViewAll);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));


        btnSwitchProfile = (ImageButton) mView.findViewById(R.id.userInfo);
        btnSwitchProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToUserInfoActivity();
            }
        });



        mAdapter = new AdapterCoffee(new AdapterCoffee.GetOnCoffee() {
            @Override
            public void clickedCoffee(ModelCoffee modelCoffee) {
                mMainActivity.goToDetailFragment(modelCoffee);
            }
        });
        viewModel = new ViewModelProvider(getActivity()).get(CoffeeViewModel.class);

        viewModel.getCoffeeList().observe(getViewLifecycleOwner(), new Observer<ArrayList<ModelCoffee>>(){
            public void onChanged(ArrayList<ModelCoffee> modelCoffees){
                mAdapter.setCoffeeModelList(modelCoffees);
                recyclerView.setAdapter(mAdapter);
            }
        });

        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        userName.setText(modelUser.getFullName().toString());
        numLoyaltyCard.setText(AppController.numberLoyaltyCard + "/8");

        mAdapterLoyaltyCard = new AdapterLoyaltyCard();
        recyclerViewLoyaltyCard.setAdapter(mAdapterLoyaltyCard);
        recyclerViewLoyaltyCard.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false));
    }

    public void clickedCoffee(ModelCoffee modelCoffee)
    {


    }

    public void switchToUserInfoActivity(){
        Intent switchIntent = new Intent(getActivity(), UserInfoActivity.class);

        getActivity().startActivity(switchIntent);
    }

}