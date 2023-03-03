package Buns;

import Ingredients.Ingredient;
import java.time.LocalTime;
import java.util.ArrayList;

public class BunWithPoppySeeds extends Bun{
    public BunWithPoppySeeds(int price, LocalTime dateTime, Ingredient ingredient) {
        super(price, dateTime, ingredient);
    }

    public BunWithPoppySeeds(int price, LocalTime dateTime, ArrayList<Ingredient> ingredients) {
        super(price, dateTime, ingredients);
    }

    @Override
    public String toString() {
        return "Булочка с маком с ингредиентами: " +
            this.getIngredients().toString() + " сделанная в : " + this.getDateTime().toString();

    }
}
