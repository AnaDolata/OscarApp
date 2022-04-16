package com.example.oscarapp.apiMovie;

import com.example.oscarapp.Model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

    @GET("filmes")
    Call<Movie> getMovies();
}
