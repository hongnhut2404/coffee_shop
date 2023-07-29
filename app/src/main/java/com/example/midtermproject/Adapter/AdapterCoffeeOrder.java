package com.example.midtermproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.midtermproject.Model.ModelCoffeeOrder;
import com.example.midtermproject.R;

import java.util.ArrayList;

public class AdapterCoffeeOrder extends RecyclerView.Adapter<AdapterCoffeeOrder.OrderViewHolder> {

    private ArrayList<ModelCoffeeOrder> mListCoffeeOrder;
    private Context context;
    public AdapterCoffeeOrder(ArrayList<ModelCoffeeOrder> mListCoffeeOrder) {
        this.mListCoffeeOrder = mListCoffeeOrder;
        this.context = context;
    }

    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_style, parent, false);
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
        holder.textPrice.setText("$ " + modelCoffeeOrder.getTotalPrice() + "");
        holder.textAttribute.setText(modelCoffeeOrder.toStringAttribute());
        holder.textQuantity.setText("x " + modelCoffeeOrder.getQuantity() + "");
        Glide.with(holder.itemView.getContext()).load(mListCoffeeOrder.get(position).getImageURL()).into(holder.imageView);

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
        private ImageView imageView;
        public OrderViewHolder( View itemView) {
            super(itemView);
            this.textCoffeeName = itemView.findViewById(R.id.textCoffeeNameCart);
            this.textAttribute = itemView.findViewById(R.id.textAttributeCart);
            this.textQuantity = itemView.findViewById(R.id.textQuantityCart);
            this.textPrice = itemView.findViewById(R.id.textPriceCart);
            this.imageView = itemView.findViewById(R.id.imageCoffeeCart);
        }
    }
}
