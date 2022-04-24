package com.example.oscarapp.apiMovie;

import com.example.oscarapp.Model.Director;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DirectorService {

    @GET("diretor")
    Call<List<Director>> getDirector();
}
