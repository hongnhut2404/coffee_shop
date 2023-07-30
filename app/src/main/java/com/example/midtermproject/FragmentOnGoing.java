package com.example.midtermproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midtermproject.Adapter.AdapterCartOrderOnGoing;


public class FragmentOnGoing extends Fragment {

    //AdapterCartOrderOnGoing mAdapterCartOrderGoing;
    RecyclerView mRecyclerView;
    View mView;
    MainActivity mMainActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_on_going, container, false);
        mMainActivity = (MainActivity) getActivity();

        //mAdapterCartOrderGoing = new AdapterCartOrderOnGoing(AppController.listModelCartOrder, requireContext());

        mRecyclerView = mView.findViewById(R.id.recOngoingOrder);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(AppController.adapterCartOrderOnGoing);



        return mView;

    }
}