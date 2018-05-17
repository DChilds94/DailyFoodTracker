import db.DBHelper;
import models.consumer.Consumer;
import models.day.Day;
import models.food.*;
import models.meal.Meal;
import models.meal.MealType;

import java.util.GregorianCalendar;

public class Runner {

    public static void main(String[] args) {

        Consumer consumer1 = new Consumer("Brian");
        Consumer consumer2 = new Consumer("Daniel");
        DBHelper.save(consumer1);
        DBHelper.save(consumer2);

        Day day = new Day(new GregorianCalendar (2018,5,11), consumer1);

        Banana banana = new Banana(10);
        Pasta spag = new Pasta(150);
        PastaSauce sauce = new PastaSauce(25);
        Meaballs meatballs = new Meaballs(80);
        DBHelper.save(banana);
        DBHelper.save(spag);
        DBHelper.save(sauce);
        DBHelper.save(meatballs);

        Meal spagBolMeatBall = new Meal(MealType.DINNER, day);
        DBHelper.save(spagBolMeatBall);

    }
}
