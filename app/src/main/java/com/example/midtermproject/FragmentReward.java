package com.example.midtermproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.midtermproject.Adapter.AdapterLoyaltyCard;
import com.example.midtermproject.Adapter.AdapterRewardHistory;
import com.example.midtermproject.Model.Date;
import com.example.midtermproject.Model.ModelRewardHistory;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class FragmentReward extends Fragment {

    private RecyclerView recReward;
    private RecyclerView recLoyaltyCard;
    private View mView;
    private MainActivity mMainActivity;

    private AdapterLoyaltyCard mAdapterLoyaltyCard;
    private Button btnRedeem;

    private TextView textTotalPoints;
    private LinearLayout layoutLoyaltyCard;
    private TextView textLoyaltyCard;

    public FragmentReward() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_reward, container, false);
        mMainActivity = (MainActivity) getActivity();
        textTotalPoints = mView.findViewById(R.id.numberPoints);
        btnRedeem = mView.findViewById(R.id.btnMoveToRedeem);
        recLoyaltyCard = mView.findViewById(R.id.recLoyatyCardReward);
        recReward = mView.findViewById(R.id.recViewReward);
        textLoyaltyCard = mView.findViewById(R.id.textNumberLoyaltyCardReward);
        layoutLoyaltyCard = mView.findViewById(R.id.layoutLoyaltyCardReward);

        layoutLoyaltyCard.setOnClickListener(new View.OnClickListener() {
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


        btnRedeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RedeemPointActivity.class);
                startActivity(intent);
            }
        });


        textTotalPoints.setText(AppController.getTotalRedeemPoints() + "");


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mMainActivity);
        recReward.setLayoutManager(linearLayoutManager);

        AdapterRewardHistory adapterRewardHistory = new AdapterRewardHistory(AppController.listModelRewardHistory);
        recReward.setAdapter(adapterRewardHistory);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mMainActivity, DividerItemDecoration.VERTICAL);
        recReward.addItemDecoration(itemDecoration);

        return mView;

    }

    @Override
    public void onStart() {
        super.onStart();
        textTotalPoints.setText(AppController.getTotalRedeemPoints() + "");
        textLoyaltyCard.setText(AppController.numberLoyaltyCard + "/8");
        mAdapterLoyaltyCard = new AdapterLoyaltyCard();
        recLoyaltyCard.setAdapter(mAdapterLoyaltyCard);
        recLoyaltyCard.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false));
    }
}