package com.example.midtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.model.Model;
import com.example.midtermproject.Model.ModelUser;

public class UserInfoActivity extends AppCompatActivity {
    ModelUser modelUser = ModelUser.getInstance();
    private EditText editName, editPhone, editAddress, editEmail;
    private String userName, userPhone, userAddress, userEmail;
    private ImageButton btnEditName, btnEditPhone, btnEditAddress, btnEditEmail, btnBackToMenu;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Intent intentUserInfo = getIntent();

        userName = intentUserInfo.getStringExtra("key_sender_name");
        userPhone = intentUserInfo.getStringExtra("key_sender_phone");
        userAddress = intentUserInfo.getStringExtra("key_sender_address");
        userEmail = intentUserInfo.getStringExtra("key_sender_email");
//        userName = modelUser.getFullName();
//        userPhone = modelUser.getPhoneNumber();
//        userAddress = modelUser.getAddress();
//        userEmail = modelUser.getEmail();

        editName = (EditText) findViewById(R.id.editUserName);
        editPhone = (EditText) findViewById(R.id.editPhoneNunber);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editEmail = (EditText) findViewById(R.id.editEmail);

        btnEditAddress = findViewById(R.id.btnEditAddress);
        btnEditName = findViewById(R.id.btnEditUserName);
        btnEditPhone =findViewById(R.id.btnEditPhoneNumber);
        btnEditEmail = findViewById(R.id.btnEditEmail);
        btnBackToMenu = findViewById(R.id.btnBackInfoMenu);

        editName.setText(userName);
        editPhone.setText(userPhone);
        editAddress.setText(userAddress);
        editEmail.setText(userEmail);

        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchIntent = new Intent(getApplicationContext(), MainActivity.class);
                switchIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(switchIntent);
            }
        });

        btnEditName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProfile(editName, 0, modelUser);
            }
        });

        btnEditPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProfile(editPhone, 1, modelUser);
            }
        });

        btnEditAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProfile(editAddress, 2, modelUser);
            }
        });

        btnEditEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProfile(editEmail, 3, modelUser);
            }
        });


    }

    public void changeProfile(TextView edit, int index, ModelUser modelUser)
    {
        if (edit.isEnabled())
        {
            edit.setText(edit.getText().toString());
            edit.setEnabled(false);
            switch (index){
                case 0:{
                    modelUser.setFullName(edit.getText().toString());
                    break;}
                case 1:{
                    modelUser.setPhoneNumber(edit.getText().toString());
                    break;}
                case 2:{
                    modelUser.setAddress(edit.getText().toString());
                    break;}
                case 3:{
                    modelUser.setEmail(edit.getText().toString());
                    break;}
            }

        }
        else
        {
            edit.setEnabled(true);
        }
    }


}
