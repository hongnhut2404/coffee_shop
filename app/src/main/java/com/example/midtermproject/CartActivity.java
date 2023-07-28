package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.midtermproject.Adapter.AdapterCoffeeOrder;
import com.example.midtermproject.Model.ModelCoffeeOrder;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<ModelCoffeeOrder> modelCoffeeOrders;
    RecyclerView recyclerView;
    AdapterCoffeeOrder mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }
}