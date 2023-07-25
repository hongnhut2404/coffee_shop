package com.example.midtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    private EditText editName, editPhone, editAddress, editEmail;

    private String userName, userPhone, userAddress, userEmail;
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

        editName.setText(userName);
        editPhone.setText(userPhone);
        editAddress.setText(userAddress);
        editEmail.setText(userEmail);


    }


}
