package com.example.fruitapp.activities;

import com.example.food.activities.BaseFoodListActivity;
import com.example.food.OnFoodReadyCallback;
import com.example.fruitapp.api.FruitJsonTask;
import com.example.fruitapp.R;


public class FruitsActivity extends BaseFoodListActivity {


    @Override
    public void fetchFood(OnFoodReadyCallback callback) {
        FruitJsonTask fruitJsonTask = new FruitJsonTask(callback);
        fruitJsonTask.execute();
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.fruits);
    }
}
