package com.example.midtermproject.Adapter;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.midtermproject.Model.ModelCoffee;
import com.example.midtermproject.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AdapterCoffeeRedeem extends RecyclerView.Adapter<AdapterCoffeeRedeem.CoffeeRedeemViewHolder>{
    private ArrayList<ModelCoffee> mListCoffeeRedeem;
    private Context context;

    public AdapterCoffeeRedeem(ArrayList<ModelCoffee> mListCoffeeRedeem) {
        this.mListCoffeeRedeem = mListCoffeeRedeem;
    }

    @NonNull
    @Override
    public CoffeeRedeemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.redeem_style, parent, false);
        return new CoffeeRedeemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeRedeemViewHolder holder, int position) {
        ModelCoffee modelCoffeeRedeem = mListCoffeeRedeem.get(position);
        if (modelCoffeeRedeem == null){
            return;
        }
        LocalDateTime time = LocalDateTime.now().plusDays(7);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = time.format(dateTimeFormatter);

        holder.textCoffeeName.setText(modelCoffeeRedeem.getCoffeeName());
        holder.textValidDate.setText("Valid date: " + formattedDateTime);
        holder.btnRedeem.setText(modelCoffeeRedeem.getRedeemPoint() + " pts");
        Glide.with(holder.itemView.getContext()).load(mListCoffeeRedeem.get(position).getImageURL()).into(holder.imageCoffee);
    }

    @Override
    public int getItemCount() {
        if (mListCoffeeRedeem != null)
        {
            return mListCoffeeRedeem.size();
        }
        return 0;
    }

    public class CoffeeRedeemViewHolder extends RecyclerView.ViewHolder{
        private TextView textCoffeeName;
        private TextView textValidDate;
        private Button btnRedeem;
        private ImageView imageCoffee;

        public CoffeeRedeemViewHolder(@NonNull View itemView) {
            super(itemView);
            textCoffeeName = itemView.findViewById(R.id.textCoffeeNameRedeem);
            textValidDate = itemView.findViewById(R.id.textDateRedeem);
            btnRedeem = itemView.findViewById(R.id.btnRedeem);
            imageCoffee = itemView.findViewById(R.id.imageCoffeeRedeem);
        }
    }
}
