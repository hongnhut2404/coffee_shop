package com.example.midtermproject.Adapter;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.ModelCache;
import com.example.midtermproject.Model.ModelCoffee;
import com.example.midtermproject.R;

import java.util.ArrayList;

public class AdapterCoffee extends RecyclerView.Adapter<AdapterCoffee.CoffeeListHolder> {
    ArrayList<ModelCoffee> coffeeModelList;

    GetOnCoffee mGetOnCoffee;

    public AdapterCoffee(GetOnCoffee mGetOnCoffee) {
        this.mGetOnCoffee = mGetOnCoffee;
    }

    @Override
    public CoffeeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffeeliststyle, parent, false);
        return new CoffeeListHolder(view, mGetOnCoffee);
    }

    @Override
    public void onBindViewHolder(CoffeeListHolder holder, int position) {
        final ModelCoffee modelCoffee = coffeeModelList.get(position);

        holder.coffeeName.setText(modelCoffee.getCoffeeName());
        Glide.with(holder.itemView.getContext()).load(coffeeModelList.get(position).getImageURL()).into(holder.imageView);

        holder.coffeeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetOnCoffee.clickedCoffee(modelCoffee);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coffeeModelList.size();
    }

    public void setCoffeeModelList(ArrayList<ModelCoffee> coffeeModelList)
    {
        this.coffeeModelList = coffeeModelList;
    }

    class CoffeeListHolder extends RecyclerView.ViewHolder{

        TextView coffeeName;
        ImageView imageView;
        GetOnCoffee getOnCoffee;
        public CoffeeListHolder(View itemView, GetOnCoffee getOnCoffee) {
            super(itemView);

            coffeeName = itemView.findViewById(R.id.nameCoffee);
            imageView = itemView.findViewById(R.id.imageCoffee);
        }

    }

    public interface GetOnCoffee{
            void clickedCoffee(ModelCoffee modelCoffee);
    }
}
