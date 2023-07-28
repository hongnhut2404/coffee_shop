package com.example.midtermproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermproject.Model.ModelCoffeeOrder;
import com.example.midtermproject.R;

import java.util.ArrayList;

public class AdapterCoffeeOrder extends RecyclerView.Adapter<AdapterCoffeeOrder.OrderViewHolder> {

    private ArrayList<ModelCoffeeOrder> mListCoffeeOrder;
    public AdapterCoffeeOrder(ArrayList<ModelCoffeeOrder> mListCoffeeOrder) {
        this.mListCoffeeOrder = mListCoffeeOrder;
    }

    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartstyle, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder( OrderViewHolder holder, int position) {
        ModelCoffeeOrder modelCoffeeOrder = mListCoffeeOrder.get(position);
        if (modelCoffeeOrder == null)
        {
            return;
        }
        holder.textCoffeeName.setText(modelCoffeeOrder.getCoffeeName());
        holder.textPrice.setText(modelCoffeeOrder.getPrice());
        holder.textAttribute.setText(modelCoffeeOrder.getIce());
        holder.textQuantity.setText(modelCoffeeOrder.getQuantity());

    }

    @Override
    public int getItemCount() {
        if (mListCoffeeOrder != null)
        {
            return mListCoffeeOrder.size();
        }
        return 0;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{

        private TextView textCoffeeName;
        private TextView textAttribute, textQuantity, textPrice;
        public OrderViewHolder( View itemView) {
            super(itemView);
            this.textCoffeeName = itemView.findViewById(R.id.textCoffeeNameCart);
            this.textAttribute = itemView.findViewById(R.id.textAttributeCart);
            this.textQuantity = itemView.findViewById(R.id.textQuantityCart);
            this.textPrice = itemView.findViewById(R.id.textPriceCart);
        }
    }
}
