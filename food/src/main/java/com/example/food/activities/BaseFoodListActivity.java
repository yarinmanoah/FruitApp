package com.example.food.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.food.entities.Food;
import com.example.food.adapters.FoodAdapter;
import com.example.food.OnFoodReadyCallback;
import com.example.food.R;
import com.example.food.entities.SortingCriteria;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFoodListActivity extends AppCompatActivity implements OnFoodReadyCallback {
    private RecyclerView recyclerView;
    private Button sortBySugarButton, sortByProteinButton, sortByCaloriesButton, resetButton;
    private TextView sortingCriteriaTv;
    private List<Food> foodList;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getToolbarTitle());
        recyclerView = findViewById(R.id.recyclerview);
        sortBySugarButton = findViewById(R.id.sortBySugarButton);
        sortByProteinButton = findViewById(R.id.sortByProteinButton);
        sortByCaloriesButton = findViewById(R.id.sortByCaloriesButton);
        resetButton = findViewById(R.id.resetButton);
        sortingCriteriaTv = findViewById(R.id.sortingCriteriaTv);
        foodList = new ArrayList<>();
        foodAdapter = new FoodAdapter(foodList);
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(foodAdapter);


        sortBySugarButton.setOnClickListener(v -> {
            handleButtonClick(getString(R.string.sugar));
        });
        sortByProteinButton.setOnClickListener(v -> {
            handleButtonClick(getString(R.string.protein));
        });
        sortByCaloriesButton.setOnClickListener(v -> {
            handleButtonClick(getString(R.string.calories));
        });
        resetButton.setOnClickListener(v -> {
            handleButtonClick("Reset");
        });

        fetchFood(this);
    }

    protected String getToolbarTitle(){
        return "";
    }

    protected RecyclerView.LayoutManager getLayoutManager(){
        return new LinearLayoutManager(this);
    }
    private void handleButtonClick (String buttonType) {
        if (!buttonType.equals("Reset")) {
            foodAdapter.sortFoodsBy(SortingCriteria.valueOf(buttonType.toUpperCase()));
            sortingCriteriaTv.setText(getString(R.string.sort_by, buttonType));
            recyclerView.scrollToPosition(0);
        } else {
            resetPage();
        }
    }

    public abstract void fetchFood(OnFoodReadyCallback callback);


    private void resetPage() {
        fetchFood(this);
        sortingCriteriaTv.setText(R.string.sort_by_none);
        recyclerView.scrollToPosition(0);

    }

    @Override
    public void onFoodsReadSuccess(List<Food> foodList) {
        foodAdapter.setFoodList(foodList);
    }

    @Override
    public void onFoodsReadFailed(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
