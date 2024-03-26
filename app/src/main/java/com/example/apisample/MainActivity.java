package com.example.apisample;

import static com.example.apisample.MyApplication.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.apisample.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DogListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adapter = new DogListAdapter();
        binding.rvDogList.setAdapter(adapter);
        binding.rvDogList.setLayoutManager(new LinearLayoutManager(this));
        setDogImageList();
    }

    private void setDogImageList() {
        Log.d("APISAMPLE","setDogImageList called");
        DogInterface dogInterface = getRetrofit().create(DogInterface.class);
        Call<List<DogImage>> call = dogInterface.getDogListImages(10);

        call.enqueue(new Callback<List<DogImage>>() {
            @Override
            public void onResponse(Call<List<DogImage>> call, Response<List<DogImage>> response) {
                Log.d("APISAMPLE","onResponse called");
                adapter.setDogImageList(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<DogImage>> call, Throwable t) {
                Log.d("APISAMPLE","onFailure called");
            }
        });
    }
}