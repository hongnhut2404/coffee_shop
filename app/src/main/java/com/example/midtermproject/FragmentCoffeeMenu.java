package com.example.midtermproject;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.midtermproject.Adapter.AdapterCoffee;
import com.example.midtermproject.MVVM.CoffeeViewModel;
import com.example.midtermproject.MVVM.Repositoryu;
import com.example.midtermproject.Model.ModelCoffee;
import com.example.midtermproject.Model.ModelUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class FragmentCoffeeMenu extends Fragment implements AdapterCoffee.GetOnCoffee{

    FirebaseFirestore firebaseFirestore;
    AdapterCoffee mAdapter;
    RecyclerView recyclerView;
    CoffeeViewModel viewModel;
    TextView userName;
    ModelUser modelUser;
    MainActivity mMainActivity;
    View mView;
    ImageButton btnSwitchProfile;

    public FragmentCoffeeMenu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_coffee_menu, container, false);
        mMainActivity = (MainActivity) getActivity();
        userName = (TextView) mView.findViewById(R.id.userName);
         modelUser = ModelUser.getInstance("Loki", "+ 84 0126183132", "anderson@gmail.com", "Ho Chi Minh City");

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
    }

    public void clickedCoffee(ModelCoffee modelCoffee)
    {


    }

    public void switchToUserInfoActivity(){
        Intent switchIntent = new Intent(getActivity(), UserInfoActivity.class);
        switchIntent.putExtra("key_sender_name", modelUser.getFullName().toString());
        switchIntent.putExtra("key_sender_address", modelUser.getAddress().toString());
        switchIntent.putExtra("key_sender_phone", modelUser.getPhoneNumber().toString());
        switchIntent.putExtra("key_sender_email", modelUser.getEmail().toString());

        getActivity().startActivity(switchIntent);
    }

}