package com.example.midtermproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midtermproject.Adapter.AdapterCoffee;
import com.example.midtermproject.MVVM.CoffeeViewModel;
import com.example.midtermproject.MVVM.Repositoryu;
import com.example.midtermproject.Model.ModelCoffee;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class FragmentCoffeeMenu extends Fragment {

    FirebaseFirestore firebaseFirestore;
    AdapterCoffee mAdapter;
    RecyclerView recyclerView;
    CoffeeViewModel viewModel;

    public FragmentCoffeeMenu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coffee_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recViewAll);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mAdapter = new AdapterCoffee();
        viewModel = new ViewModelProvider(getActivity()).get(CoffeeViewModel.class);

        viewModel.getCoffeeList().observe(getViewLifecycleOwner(), new Observer<ArrayList<ModelCoffee>>(){
            public void onChanged(ArrayList<ModelCoffee> modelCoffees){
                mAdapter.setCoffeeModelList(modelCoffees);
                recyclerView.setAdapter(mAdapter);
            }
        });
    }


}