package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.midtermproject.Adapter.AdapterCoffeeRedeem;

public class RedeemPointActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterCoffeeRedeem mAdapterCoffeeRedeem;

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_point);

        mAdapterCoffeeRedeem = new AdapterCoffeeRedeem(AppController.listModelCoffee);
        btnBack = findViewById(R.id.btnBackRedeemReward);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("reward_activity", 2);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recRedeem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(mAdapterCoffeeRedeem);
    }
}