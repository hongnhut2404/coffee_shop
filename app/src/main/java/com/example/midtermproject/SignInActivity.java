package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.midtermproject.Model.ModelUser;

public class SignInActivity extends AppCompatActivity {

    ModelUser modelUser = ModelUser.getInstance();
    private EditText editName;
    private EditText editPassword;
    private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editName = findViewById(R.id.editTextSignUsername);
        editPassword = findViewById(R.id.editTextSignPassword);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                if (name.equals(modelUser.getFullName()) && password.equals(modelUser.getPassword()))
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    editPassword.getText().clear();
                    editName.getText().clear();
                    Toast.makeText(getApplicationContext(), "Your username or password is wrong.\n Please input your information again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}