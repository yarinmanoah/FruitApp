package com.example.vegetables.activities;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.activities.BaseFoodListActivity;
import com.example.food.entities.Food;
import com.example.food.OnFoodReadyCallback;
import com.example.vegetables2.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class VegetablesActivity extends BaseFoodListActivity {


    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(this, 2);
    }

    @Override
    public void fetchFood(OnFoodReadyCallback callback) {
        try {
            InputStream inputStream = getApplicationContext().getAssets().open("vegetables.json");
            InputStreamReader reader = new InputStreamReader(inputStream);
            Type foodListType = new TypeToken<List<Food>>() {}.getType();
            List<Food> foods = new Gson().fromJson(reader, foodListType);
            reader.close();
            callback.onFoodsReadSuccess(foods);

        } catch (Exception e) {
            e.printStackTrace();
            callback.onFoodsReadFailed(e);
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.vegetables);
    }
}