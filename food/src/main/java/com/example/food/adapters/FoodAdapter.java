package com.example.food.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.R;
import com.example.food.entities.Food;
import com.example.food.entities.SortingCriteria;

import java.util.Comparator;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> foodList;

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void sortFoodsBy(SortingCriteria sortingCriteria) {
        switch (sortingCriteria) {
            case SUGAR:
                foodList.sort(Comparator.comparingDouble(Food::getSugar));
                break;
            case PROTEIN:
                foodList.sort(Comparator.comparingDouble(Food::getProtein));
                break;
            case CALORIES:
                foodList.sort(Comparator.comparingDouble(Food::getCalories));
                break;
        }
        notifyDataSetChanged();
    }

    public void setFoodList(List<Food> list) {
        this.foodList = list;
        notifyDataSetChanged();
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView, sugarTextView, proteinTextView, caloriesTextView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.foodTitletv);
            sugarTextView = itemView.findViewById(R.id.foodSugarTv);
            proteinTextView = itemView.findViewById(R.id.foodProteinTv);
            caloriesTextView = itemView.findViewById(R.id.foodCaloriesTv);
        }

        public void bind(Food food) {
            nameTextView.setText(food.getName());
            sugarTextView.setText("Sugar: " + food.getSugar());
            proteinTextView.setText("Protein: " + food.getProtein());
            caloriesTextView.setText("Calories: " + food.getCalories());
        }
    }
}
