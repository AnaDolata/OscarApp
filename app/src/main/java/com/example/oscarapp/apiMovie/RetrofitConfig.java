package com.example.oscarapp.apiMovie;

import com.example.oscarapp.Model.Director;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://wecodecorp.com.br/ufpr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public MovieService getMovieService(){
        return this.retrofit.create(MovieService.class);
    }
    public DirectorService getDirectorService(){
        return this.retrofit.create(DirectorService.class);
    }


}
