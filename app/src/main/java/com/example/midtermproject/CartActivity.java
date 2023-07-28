package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.midtermproject.Adapter.AdapterCoffeeOrder;
import com.example.midtermproject.Model.ModelCoffeeOrder;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterCoffeeOrder mAdapter;
    ImageButton btnBackMenu;
    Button btnCheckoutCart;
    TextView textTotalPrice;

    int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        ModelCoffeeOrder modelCoffeeOrder = (ModelCoffeeOrder) getIntent().getSerializableExtra("object_coffee_order");
        AppController.listModelCoffeeOrder.add(modelCoffeeOrder);

        btnBackMenu = findViewById(R.id.btnBackCartMenu);
        btnCheckoutCart = findViewById(R.id.btnCheckoutCart);
        textTotalPrice = findViewById(R.id.textTotalPriceCart);

        mAdapter = new AdapterCoffeeOrder(AppController.listModelCoffeeOrder);
        Log.d("list size",AppController.listModelCoffeeOrder.size()+"");

        recyclerView = findViewById(R.id.recCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(mAdapter);

        for (int i = 0; i < AppController.listModelCoffeeOrder.size(); i++)
        {
            totalPrice += AppController.listModelCoffeeOrder.get(i).getTotalPrice();
        }
        textTotalPrice.setText("$ " + totalPrice + "");

        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });



    }
}