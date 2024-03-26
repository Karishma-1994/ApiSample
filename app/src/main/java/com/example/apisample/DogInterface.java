package com.example.apisample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DogInterface {

    @GET("/v1/images/search")
    Call<List<DogImage>> getDogListImages(@Query("limit") Integer limit);

}