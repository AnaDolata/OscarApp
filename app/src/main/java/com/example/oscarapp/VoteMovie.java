package com.example.oscarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscarapp.Adapter.AdapterMovies;
import com.example.oscarapp.Adapter.RecyclerItemClickListener;
import com.example.oscarapp.Model.Movie;
import com.example.oscarapp.apiMovie.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoteMovie extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerViewMovies;
    private AdapterMovies adapterMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_movie);

        recyclerViewMovies = findViewById(R.id.recyclerViewMovies);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando filmes...");
        progressDialog.show();

        Call<List<Movie>> call = new RetrofitConfig().getMovieService().getMovie();
        call.enqueue(new Callback<List<Movie>>(){

            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()) {
                    movieList = response.body();
                    adapterMovies = new AdapterMovies(movieList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerViewMovies.setLayoutManager(layoutManager);
                    recyclerViewMovies.setHasFixedSize(true);
                    recyclerViewMovies.setAdapter(adapterMovies);
                    progressDialog.dismiss();

                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(VoteMovie.this, "Erro ao buscar filmes", Toast.LENGTH_SHORT).show();
            }
        });

        Intent it = new Intent(this, VoteForMovie.class);

        recyclerViewMovies.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewMovies,
                        new RecyclerItemClickListener.OnItemClickListener(){
                            @Override
                            public void onItemClick(View view, int position) {
                                Movie obj = movieList.get(position);
                                Bundle params = new Bundle();
                                params.putString("name", obj.getNome());
                                params.putString("genre", obj.getGenero());
                                params.putString("img", obj.getFoto());
                                it.putExtras(params);
                                startActivity(it);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }
}