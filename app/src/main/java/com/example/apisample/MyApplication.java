package com.example.apisample;

import android.app.Application;
import android.util.Log;

import retrofit2.Retrofit;

public class MyApplication extends Application {

    static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("APISAMPLE","onCreate called");
        retrofit = ApiClient.getClient(this);
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
