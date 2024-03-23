package com.example.apisample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.apisample.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        DogListAdapter adapter = new DogListAdapter();
        binding.rvDogList.setAdapter(adapter);
        binding.rvDogList.setLayoutManager(new LinearLayoutManager(this));

        adapter.setDogBreedList(getDogBreedList());
    }

    private List<String> getDogBreedList() {
        List<String> dogBreedList = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            dogBreedList.add("Siberian Husky " + i);
        }
        return dogBreedList;
    }
}