package Buns;

import Ingredients.Ingredient;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Bun {

    private int price;
    private LocalTime dateTime;

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
        this.ingredients.add(ingredient);
    }

    public Bun(int price, LocalTime dateTime, ArrayList<Ingredient> ingredients) {
        this.price = price;
        this.dateTime = dateTime;
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public boolean findIngredient(Ingredient ingredient){
        return ingredients.stream().filter(i -> i.getName().equals(ingredient.getName())).count() > 0;
    }
    public abstract String toString();
}
