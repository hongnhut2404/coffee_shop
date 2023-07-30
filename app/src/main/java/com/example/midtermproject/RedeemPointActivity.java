package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.midtermproject.Adapter.AdapterCoffeeRedeem;

public class RedeemPointActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterCoffeeRedeem mAdapterCoffeeRedeem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_point);

        mAdapterCoffeeRedeem = new AdapterCoffeeRedeem(AppController.listModelCoffee);

        recyclerView = findViewById(R.id.recRedeem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(mAdapterCoffeeRedeem);
    }
}