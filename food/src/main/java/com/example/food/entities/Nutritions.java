package com.example.food.entities;

public class Nutritions {
    private int calories;
    private double sugar;
    private double protein;

    public Nutritions(int calories, double sugar, double protein) {
        this.calories = calories;
        this.sugar = sugar;
        this.protein = protein;
    }
    public Nutritions() {
    }
    public Nutritions setSugar(double sugar) {
        this.sugar = sugar;
        return this;
    }
    public Nutritions setProtein(double protein) {
        this.protein = protein;
        return this;
    }
    public Nutritions setCalories(int calories) {
        this.calories = calories;
        return this;
    }
    public int getCalories() {
        return calories;
    }

    public double getSugar() {
        return sugar;
    }

    public double getProtein() {
        return protein;
    }
}
