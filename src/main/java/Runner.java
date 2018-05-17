import db.DBDay;
import db.DBHelper;
import models.consumer.Consumer;
import models.day.Day;
import models.food.*;
import models.meal.Meal;
import models.meal.MealType;

import java.util.GregorianCalendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Consumer consumer1 = new Consumer("Brian");
        Consumer consumer2 = new Consumer("Daniel");
        DBHelper.save(consumer1);
        DBHelper.save(consumer2);

        Day day = new Day(new GregorianCalendar (2018,5,11), consumer1);
        DBHelper.save(day);
        Food banana = new Food("Banana", 10);
        Food spag = new Food ("Spag", 150);
        Food sauce = new Food ("Suace", 25);
        Food meatballs = new Food ("Meatballs", 80);
        DBHelper.save(banana);
        DBHelper.save(spag);
        DBHelper.save(sauce);
        DBHelper.save(meatballs);

        Meal meal1 = new Meal(MealType.DINNER, day);
        DBHelper.save(meal1);

        consumer1.logFood(day, meal1, spag);
        List<Meal> mealsInDay = DBDay.getMealFromDay(day);


    }
}
