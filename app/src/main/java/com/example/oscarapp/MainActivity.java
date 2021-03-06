package com.example.oscarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oscarapp.ConfirmVote;
import com.example.oscarapp.R;
import com.example.oscarapp.VoteDirector;
import com.example.oscarapp.VoteMovie;
import com.example.oscarapp.apiMovie.DownloadTask;

public class MainActivity extends AppCompatActivity {

    TextView textToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToken = findViewById(R.id.textViewToken);

        Intent it = getIntent();
        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                int token = params.getInt("token");
                textToken.setText(String.valueOf(token));
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //infla o menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.vote_movie){
            Intent intent = new Intent(getApplicationContext(), VoteMovie.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.vote_director){
            Intent intent = new Intent(getApplicationContext(), VoteDirector.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.confirm_vote){
            Intent intent = new Intent(getApplicationContext(), ConfirmVote.class);
            startActivity(intent);
        }else{
            //opção sair
        }
        return super.onOptionsItemSelected(item);
    }
}