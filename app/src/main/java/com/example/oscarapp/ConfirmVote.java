package com.example.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmVote extends AppCompatActivity {

    TextView TVfilme, TVdiretor;
    EditText editTextToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_vote);
        TVfilme = findViewById(R.id.txtVotoFilme);
        TVdiretor = findViewById(R.id.txtVotoDiretor);
        editTextToken = findViewById(R.id.editTextToken);

        Intent it = getIntent();
        if(it!=null){
            String filme = it.getStringExtra("filme");
            TVfilme.setText(filme);
        }
    }
    public void btnConfirmarVoto(View view){


    }
}