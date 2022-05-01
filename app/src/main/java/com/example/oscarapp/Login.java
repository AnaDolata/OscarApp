package com.example.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oscarapp.apiMovie.RequestTask;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnEntrar (View view){
        EditText inputName = findViewById(R.id.txtUsername);
        EditText inputPwrd = findViewById(R.id.txtPassword);

        String name = inputName.getText().toString();
        String password = inputPwrd.getText().toString();
        String msg = "";
        RequestTask task = new RequestTask(msg, Login.this);
        task.execute(name);


    }
}