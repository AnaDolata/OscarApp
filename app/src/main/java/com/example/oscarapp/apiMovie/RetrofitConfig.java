package com.example.oscarapp.apiMovie;

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
}
