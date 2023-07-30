package com.example.midtermproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midtermproject.Adapter.AdapterCartOrderOnGoing;


public class FragmentHistory extends Fragment {

    //AdapterCartOrderOnGoing mAdapterCartOrderHistory;
    RecyclerView mRecyclerView;
    View mView;
    MainActivity mMainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_history, container, false);

        mMainActivity = (MainActivity) getActivity();

        //mAdapterCartOrderHistory = new AdapterCartOrderOnGoing(AppController.listModelCartOrderHistory, requireContext());

        mRecyclerView = mView.findViewById(R.id.recHistoryOrder);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(AppController.adapterCartOrderHistory);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mMainActivity, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        return mView;
    }
}