package Buns;

import Ingredients.Ingredient;
import java.time.LocalTime;
import java.util.ArrayList;

public class Donut extends Bun{
    public Donut(int price, LocalTime dateTime, Ingredient ingredient) {
        super(price, dateTime, ingredient);
    }

    public Donut(int price, LocalTime dateTime, ArrayList<Ingredient> ingredients) {
        super(price, dateTime, ingredients);
    }

    @Override
    public String toString() {
        return "Пончик с ингредиентами: " +
                this.getIngredients().toString() + " сделанный в: " + this.getDateTime().toString();

    }
}
