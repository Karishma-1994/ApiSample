package com.example.apisample;

import android.content.Context;
import android.util.Log;

import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.thedogapi.com";
    private static String API_KEY = "live_5u17zWUTKjxNxldB9P1xAkTfwMLpz6PA4AgxeBtbk4cVyRXKC9T0Y0NN4lQ576ZT";

    public static Retrofit getClient(Context context) {
        if (retrofit == null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Interceptor apiKeyInterceptor = chain -> {
                Request originalRequest = chain.request();
                Request newRequest = originalRequest.newBuilder()
                        .header("x-api-key", API_KEY)
                        .build();
                return chain.proceed(newRequest);
            };

            // Build OkHttpClient with the Interceptor
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(apiKeyInterceptor)
                    .addInterceptor(new ChuckerInterceptor(context))
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
