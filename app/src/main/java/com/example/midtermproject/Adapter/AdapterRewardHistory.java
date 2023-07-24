package com.example.midtermproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermproject.Model.ModelRewardHistory;
import com.example.midtermproject.R;

import java.util.ArrayList;

public class AdapterRewardHistory extends  RecyclerView.Adapter<AdapterRewardHistory.RewardHistoryViewHolder>{
    public AdapterRewardHistory(ArrayList<ModelRewardHistory> mListRewardHistory) {
        this.mListRewardHistory = mListRewardHistory;
    }

    private ArrayList<ModelRewardHistory> mListRewardHistory;
    @NonNull
    @Override
    public RewardHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.historyrewardstyle, parent, false);
        return new RewardHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardHistoryViewHolder holder, int position) {
        ModelRewardHistory modelRewardHistory = mListRewardHistory.get(position);
        if (modelRewardHistory == null)
        {
            return;
        }
        holder.textCoffeeName.setText(modelRewardHistory.getCoffeeNameHistoryReward());
    }

    @Override
    public int getItemCount() {
        if (mListRewardHistory != null)
        {
            return mListRewardHistory.size();
        }
        return 0;
    }

    public class RewardHistoryViewHolder extends RecyclerView.ViewHolder{

        private TextView textCoffeeName;

        public RewardHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textCoffeeName = itemView.findViewById(R.id.nameCoffeeHistory);
        }
    }
}
