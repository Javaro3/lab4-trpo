package com.example.Buns;

import com.example.Ingredients.Ingredient;

import java.time.LocalTime;
import java.util.ArrayList;


/**
 * Абстрактный класс Bun
 */
public abstract class Bun {

    /**
     * Цена булочки
     */
    private int price;

    /**
     *  Время когда булочка была сделана
     */
    private LocalTime dateTime;

    /**
     * Список ингридиентов в этой булочке
     */
    private ArrayList<Ingredient> ingredients;


    public int getPrice() {
        return price;
    }

    public LocalTime getDateTime() {
        return dateTime;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Bun(int price, LocalTime dateTime, Ingredient ingredient) {
        this.price = price;
        this.dateTime = dateTime;
        this.ingredients = new ArrayList<>();
        addIngredient(ingredient);
    }

    public Bun(int price, LocalTime dateTime, ArrayList<Ingredient> ingredients) {
        this.price = price;
        this.dateTime = dateTime;
        this.ingredients = ingredients;
    }

    /**
     * Метод для добавления новых ингредиентов в список ingredients
     * @param ingredient ингредиент который будет добавлен в список ingredients
     */
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    /**
     *
     * @param ingredient ингредиент который проверяется
     * @return true - если ингредиент есть в списке. false - если ингредиента нет в списке
     */
    public boolean findIngredient(Ingredient ingredient){
        return ingredients.stream().filter(i -> i.getName().equals(ingredient.getName())).count() > 0;
    }
    public abstract String toString();
}
