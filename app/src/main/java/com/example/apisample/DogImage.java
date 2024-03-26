package com.example.apisample;

import com.google.gson.annotations.SerializedName;

public class DogImage {

    @SerializedName("id")
    String id;

    @SerializedName("url")
    String imageUrl;

    @SerializedName("width")
    int width;

    @SerializedName("height")
    int height;
}
