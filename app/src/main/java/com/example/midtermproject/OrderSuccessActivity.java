package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firestore.v1.StructuredQuery;

public class OrderSuccessActivity extends AppCompatActivity {

    Button btnTrackMyOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        btnTrackMyOrder = findViewById(R.id.btnTrackOrder);

        btnTrackMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("order_success_activity", 3);
                startActivity(intent);
            }
        });
    }
}