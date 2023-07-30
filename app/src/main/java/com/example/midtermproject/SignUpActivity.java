package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.midtermproject.Model.ModelUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText editName, editPassword, editPhone, editAddress, editEmail;
    ModelUser modelUser=ModelUser.getInstance();
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editName = findViewById(R.id.editTextSignUpName);
        editPassword = findViewById(R.id.editTextSignUpPassword);
        editAddress = findViewById(R.id.editTextSignUpAddress);
        editPhone = findViewById(R.id.editTextSignUpPhone);
        editEmail = findViewById(R.id.editTextSignUpEmail);

        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String phone = editPhone.getText().toString();
                String password = editPassword.getText().toString();
                String address = editAddress.getText().toString();
                String email = editEmail.getText().toString();

                modelUser.setFullName(name);
                modelUser.setAddress(address);
                modelUser.setEmail(email);
                modelUser.setPhoneNumber(phone);
                modelUser.setPassword(password);

                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);

            }
        });
    }
}