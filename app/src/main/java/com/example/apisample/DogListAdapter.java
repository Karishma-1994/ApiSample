package com.example.apisample;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apisample.databinding.DogListLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.DogListViewHolder> {

    private List<String> dogBreedList = new ArrayList<>();

    @NonNull
    @Override
    public DogListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DogListLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.dog_list_layout, parent, false);

        return new DogListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DogListViewHolder holder, int position) {
        holder.bind(dogBreedList.get(position));
    }

    @Override
    public int getItemCount() {
        return dogBreedList.size();
    }

    public void setDogBreedList(List<String> dogBreedList) {
        this.dogBreedList = dogBreedList;
    }

    public class DogListViewHolder extends RecyclerView.ViewHolder {

        private DogListLayoutBinding binding;

        public DogListViewHolder(@NonNull DogListLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String dogBreedName) {
            binding.tvDogBreedName.setText(dogBreedName);

        }
    }
}
