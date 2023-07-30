package com.example.midtermproject.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermproject.AppController;
import com.example.midtermproject.R;

public class AdapterLoyaltyCard extends RecyclerView.Adapter<AdapterLoyaltyCard.LoyaltyCardViewHolder> {

    private Context context;
    public AdapterLoyaltyCard() {
    }

    @NonNull
    @Override
    public LoyaltyCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.loyalty_card_style, parent, false);
        return new LoyaltyCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoyaltyCardViewHolder holder, int position) {
        for (int i = AppController.numberLoyaltyCard; i < 8; i++)
        {
            holder.imageView.setImageResource(R.drawable.royaltycarduncheck);
        }
        for (int i = 0; i < AppController.numberLoyaltyCard; i++)
        {
            holder.imageView.setImageResource(R.drawable.royaltycardcheck);
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class LoyaltyCardViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public LoyaltyCardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageLoyaltyCard);
        }
    }
}
