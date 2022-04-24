package com.example.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscarapp.Model.Movie;
import com.example.oscarapp.apiMovie.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoteMovie extends AppCompatActivity {

    TextView output;
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_movie);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando filmes...");
        progressDialog.show();

        output = findViewById(R.id.textView);

        Call<List<Movie>> call = new RetrofitConfig().getMovieService().getMovie();
        call.enqueue(new Callback<List<Movie>>(){

            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()) {
                    movieList = response.body();
                    for (int i = 0; i < 4; i++) {
                        Movie movie = movieList.get(i);
                        output.setText(output.getText() + "\n" + movie.getNome());
                    }
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                progressDialog.dismiss();
                output.setText("Erro ao buscar filmes");
            }
        });
    }
}