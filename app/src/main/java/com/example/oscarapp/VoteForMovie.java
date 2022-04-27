package com.example.oscarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oscarapp.apiMovie.DownloadTask;

public class VoteForMovie extends AppCompatActivity {

    private TextView name, genero;
    private ImageView img;
    String voto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_for_movie);

        name = findViewById(R.id.textViewMovieName);
        genero = findViewById(R.id.textViewMovieGender);
        img = findViewById(R.id.imageView);

        Intent it = getIntent();
        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                String movieName = params.getString("name");
                String movieGenre = params.getString("genre");
                String url = params.getString("img");
                name.setText(movieName);
                genero.setText(movieGenre);
                DownloadTask task = new DownloadTask(img);
                task.execute(url);
            }
        }
    }

    public void voteMovie(View view){

    }
}