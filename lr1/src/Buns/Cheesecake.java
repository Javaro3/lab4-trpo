package Buns;

import Ingredients.Ingredient;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Класс чизкейк
 */
public class Cheesecake extends Bun{
    public Cheesecake(int price, LocalTime dateTime, Ingredient ingredient) {
        super(price, dateTime, ingredient);
    }

    public Cheesecake(int price, LocalTime dateTime, ArrayList<Ingredient> ingredients) {
        super(price, dateTime, ingredients);
    }

    @Override
    public String toString() {
        return "Чизкейк с ингредиентами: " +
                this.getIngredients() + " сделанный в: " + this.getDateTime();

    }
}
