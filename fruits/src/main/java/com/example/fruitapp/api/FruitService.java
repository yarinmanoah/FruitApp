package com.example.fruitapp.api;

import com.example.food.entities.Food;

import java.util.List;
import retrofit.Call;
import retrofit.http.GET;
public interface FruitService {
    @GET("api/fruit/all")
    Call<List<Food>> getFruits();
}
