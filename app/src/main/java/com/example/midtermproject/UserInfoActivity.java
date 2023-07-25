package com.example.midtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    private EditText editName, editPhone, editAddress, editEmail;
    private String userName, userPhone, userAddress, userEmail;

    private ImageButton btnEditName, btnEditPhone, btnEditAddress, btnEditEmail;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Intent intentUserInfo = getIntent();

        userName = intentUserInfo.getStringExtra("key_sender_name");
        userPhone = intentUserInfo.getStringExtra("key_sender_phone");
        userAddress = intentUserInfo.getStringExtra("key_sender_address");
        userEmail = intentUserInfo.getStringExtra("key_sender_email");

        editName = (EditText) findViewById(R.id.editUserName);
        editPhone = (EditText) findViewById(R.id.editPhoneNunber);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editEmail = (EditText) findViewById(R.id.editEmail);

        btnEditAddress = findViewById(R.id.btnEditAddress);
        btnEditName = findViewById(R.id.btnEditUserName);
        btnEditPhone =findViewById(R.id.btnEditPhoneNumber);
        btnEditEmail = findViewById(R.id.btnEditEmail);

        editName.setText(userName);
        editPhone.setText(userPhone);
        editAddress.setText(userAddress);
        editEmail.setText(userEmail);

        btnEditName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProfile(editName, userName);
            }
        });

        btnEditPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProfile(editPhone, userPhone);
            }
        });

        btnEditAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProfile(editAddress, userAddress);
            }
        });

        btnEditEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProfile(editEmail, userEmail);
            }
        });


    }

    public void changeProfile(TextView edit, String editInfo)
    {
        if (edit.isEnabled())
        {
            edit.setText(edit.getText().toString());
            editInfo = edit.getText().toString();
            edit.setEnabled(false);
        }
        else
        {
            edit.setEnabled(true);
        }
    }


}
