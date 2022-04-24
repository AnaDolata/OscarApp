package com.example.oscarapp.apiMovie;

import com.example.oscarapp.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

    @GET("filme")
    Call<List<Movie>> getMovie();
}
