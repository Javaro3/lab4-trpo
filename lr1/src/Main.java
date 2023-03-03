import Buns.Bun;
import Buns.BunWithPoppySeeds;
import Buns.Cheesecake;
import Buns.Donut;
import Ingredients.Ingredient;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bun bun1 = new Cheesecake(120, LocalTime.of(12, 12), new Ingredient("Перец"));
        Bun bun2 = new Cheesecake(130, LocalTime.of(12, 03), new Ingredient("Карица"));
        Bun bun3 = new Cheesecake(150, LocalTime.of(12, 01), new Ingredient("Паприка"));
        Bun bun4 = new Cheesecake(90, LocalTime.of(11, 02), new Ingredient("Перец"));
        Bun bun5 = new BunWithPoppySeeds(230, LocalTime.of(13, 0), new Ingredient("Мак"));
        Bun bun6 = new Donut(130, LocalTime.of(11, 54), new Ingredient("Мак"));
        Bun bun7 = new BunWithPoppySeeds(70, LocalTime.of(13, 04), new Ingredient("Перец"));
        Bun bun8 = new BunWithPoppySeeds(150, LocalTime.of( 13, 04), new Ingredient("Хмеле-Сунеле"));
        Bun bun9 = new Donut(110, LocalTime.of(12, 12), new Ingredient("Кокао"));
        Bun bun10 = new Donut(100, LocalTime.of(12, 01), new Ingredient("Перец"));

        bun1.addIngredient(new Ingredient("Карица"));


        ArrayList<Bun> buns = new ArrayList<>();
        buns.add(bun1);
        buns.add(bun2);
        buns.add(bun3);
        buns.add(bun4);
        buns.add(bun5);
        buns.add(bun6);
        buns.add(bun7);
        buns.add(bun8);
        buns.add(bun9);
        buns.add(bun10);
;

        Scanner s = new Scanner(System.in);
        System.out.println("Введите час: ");
        int hour = s.nextInt();
        System.out.println("Введите минуту: ");
        int minute = s.nextInt();


        LocalTime currentTime = LocalTime.of(hour, minute, 0);


        System.out.println("Булки сделанные 5 мин. назад: ");
        for(Bun bun : buns){
            long res = ChronoUnit.MINUTES.between(currentTime, bun.getDateTime());
            if(res == -5 ){
                System.out.println(bun);
            }
        }


        System.out.println("\n\nБулки с перцем: ");
        for(Bun bun : buns){
            if(bun.findIngredient(new Ingredient("Перец"))){
                System.out.println(bun);
            }
        }
    }
}