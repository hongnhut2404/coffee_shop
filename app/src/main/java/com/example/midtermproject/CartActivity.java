package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.midtermproject.Adapter.AdapterCoffeeOrder;
import com.example.midtermproject.Model.ModelCoffeeOrder;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterCoffeeOrder mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        ModelCoffeeOrder modelCoffeeOrder = (ModelCoffeeOrder) getIntent().getSerializableExtra("object_coffee_order");
        AppController.listModelCoffeeOrder.add(modelCoffeeOrder);

        mAdapter = new AdapterCoffeeOrder(AppController.listModelCoffeeOrder);
        Log.d("list size",AppController.listModelCoffeeOrder.size()+"");

        recyclerView = findViewById(R.id.recCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(mAdapter);




    }
}