package com.example.midtermproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermproject.AppController;
import com.example.midtermproject.FragmentOnGoing;
import com.example.midtermproject.Model.ModelCartOrder;
import com.example.midtermproject.Model.ModelCoffeeOrder;
import com.example.midtermproject.Model.ModelUser;
import com.example.midtermproject.R;

import java.util.ArrayList;

public class AdapterCartOrderOnGoing extends RecyclerView.Adapter<AdapterCartOrderOnGoing.CartOrderOnGoingViewHolder> {
    private ArrayList<ModelCartOrder> mListCartOrder;
    private ModelUser modelUser = ModelUser.getInstance();
    private Context context;
    private Fragment fragment;

    public AdapterCartOrderOnGoing(ArrayList<ModelCartOrder> mListCartOrder, Context context, Fragment fragment) {
        this.mListCartOrder = mListCartOrder;
        this.context = context;
        this.fragment = fragment;
    }

    public AdapterCartOrderOnGoing(ArrayList<ModelCartOrder> mListCartOrder, Context context) {
        this.mListCartOrder = mListCartOrder;
        this.context = context;
    }

    @NonNull
    @Override
    public CartOrderOnGoingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_style, parent, false);
        return new CartOrderOnGoingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCartOrderOnGoing.CartOrderOnGoingViewHolder holder, int position) {
        ModelCartOrder modelCartOrder = mListCartOrder.get(holder.getLayoutPosition());
        if (modelCartOrder == null)
        {
            return;
        }
        holder.textPriceOrder.setText("$ " + modelCartOrder.calculateCartPrice());
        holder.textAddressOrder.setText(modelCartOrder.getAddress());
        holder.textDateTimeOrder.setText(modelCartOrder.toStringDate());
        holder.textCoffeeNameOrder.setText(modelCartOrder.toStringName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragment instanceof FragmentOnGoing)
                {
                    ModelCartOrder temp = new ModelCartOrder(modelCartOrder);
                    AppController.removeOnGoing(holder.getLayoutPosition());
                    AppController.addHistory(temp);

                    Toast.makeText(
                            context,
                            "Order successfully",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListCartOrder != null)
        {
            return mListCartOrder.size();
        }
        return 0;
    }

    public class CartOrderOnGoingViewHolder extends RecyclerView.ViewHolder{

        TextView textDateTimeOrder;
        TextView textCoffeeNameOrder;
        TextView textAddressOrder;
        TextView textPriceOrder;

        public CartOrderOnGoingViewHolder(@NonNull View itemView) {
            super(itemView);
            textDateTimeOrder = itemView.findViewById(R.id.textDateTimeOrder);
            textCoffeeNameOrder = itemView.findViewById(R.id.textCoffeeNameOrder);
            textAddressOrder = itemView.findViewById(R.id.textAddressOrder);
            textPriceOrder = itemView.findViewById(R.id.textPriceOrder);
        }
    }
}
