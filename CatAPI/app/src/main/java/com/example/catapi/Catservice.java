package com.example.catapi;

import com.example.catapi.Cat;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Catservice
{
    String BASE_URL = "https://api.thecatapi.com";
    @GET("/v1/images{search}")
    Call<Cat> getRandomCat(@Path("search")String search);


}
