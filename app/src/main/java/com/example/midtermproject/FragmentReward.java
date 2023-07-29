package com.example.midtermproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.midtermproject.Adapter.AdapterRewardHistory;
import com.example.midtermproject.Model.Date;
import com.example.midtermproject.Model.ModelRewardHistory;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class FragmentReward extends Fragment {

    private RecyclerView recReward;
    private View mView;
    private MainActivity mMainActivity;

    private TextView textTotalPoints;

    public FragmentReward() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_reward, container, false);
        mMainActivity = (MainActivity) getActivity();
        textTotalPoints = mView.findViewById(R.id.numberPoints);

        textTotalPoints.setText(AppController.getTotalRedeemPoints() + "");

        recReward = mView.findViewById(R.id.recViewReward);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mMainActivity);
        recReward.setLayoutManager(linearLayoutManager);

        AdapterRewardHistory adapterRewardHistory = new AdapterRewardHistory(AppController.listModelRewardHistory);
        recReward.setAdapter(adapterRewardHistory);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mMainActivity, DividerItemDecoration.VERTICAL);
        recReward.addItemDecoration(itemDecoration);

        return mView;

    }
}