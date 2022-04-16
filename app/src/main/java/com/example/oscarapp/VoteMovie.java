package com.example.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.oscarapp.Model.Movie;
import com.example.oscarapp.apiMovie.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoteMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_movie);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando filmes...");
        progressDialog.show();

        Call<Movie> call = new RetrofitConfig().getMovieService().getMovies();
        call.enqueue(new Callback<Movie> (){

            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()){
                    Movie movie = response.body();
                    progressDialog.dismiss();
                    //set list
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                //Toast.makeText(this, "Erro ao exibir a lista", Toast.LENGTH_SHORT).show();
            }
        });
    }
}