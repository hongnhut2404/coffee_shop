package com.example.midtermproject.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.midtermproject.Model.ModelCoffee;
import com.example.midtermproject.R;

import java.util.ArrayList;

public class AdapterCoffee extends RecyclerView.Adapter<AdapterCoffee.CoffeeListHolder> {
    ArrayList<ModelCoffee> coffeeModelList;
    GetOnCoffee interfaceGetCoffee;

    @Override
    public CoffeeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffeeliststyle, parent, false);
        return new CoffeeListHolder(view);
    }

    @Override
    public void onBindViewHolder(CoffeeListHolder holder, int position) {
        holder.coffeeName.setText(coffeeModelList.get(position).getCoffeeName());
        Glide.with(holder.itemView.getContext()).load(coffeeModelList.get(position).getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return coffeeModelList.size();
    }

    public void setCoffeeModelList(ArrayList<ModelCoffee> coffeeModelList)
    {
        this.coffeeModelList = coffeeModelList;
    }

    class CoffeeListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView coffeeName;
        ImageView imageView;
        public CoffeeListHolder(View itemView) {
            super(itemView);

            coffeeName = itemView.findViewById(R.id.nameCoffee);
            imageView = itemView.findViewById(R.id.imageCoffee);

            coffeeName.setOnClickListener(this);
            imageView.setOnClickListener(this);
        }

        public void onClick(View v)
        {
            interfaceGetCoffee.clickedCoffee(getAdapterPosition(), coffeeModelList);
        }
    }

    public interface GetOnCoffee{
        void clickedCoffee(int position, ArrayList<ModelCoffee> modelCoffees);
    }
}
