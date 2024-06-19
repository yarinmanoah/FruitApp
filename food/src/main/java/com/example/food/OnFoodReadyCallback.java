package com.example.food;

import com.example.food.entities.Food;

import java.util.List;

public interface OnFoodReadyCallback {
    void onFoodsReadSuccess(List<Food> foodList);
    void onFoodsReadFailed(Exception e);

}
