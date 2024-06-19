package com.example.food.entities;

public class Food {
    private String name;
    private Nutritions nutritions;

    public Food(String name, Nutritions nutritions) {
        this.name = name;
        this.nutritions = nutritions;
    }

    public String getName() {
        return name;
    }

    public double getSugar() {
        return nutritions.getSugar();
    }

    public double getProtein() {
        return nutritions.getProtein();
    }

    public double getCalories() {
        return nutritions.getCalories();
    }
}
