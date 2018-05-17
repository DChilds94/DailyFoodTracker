package db;

import models.food.Food;
import models.meal.Meal;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBMeal {

    private static Session session;

    public static List<Food> getFoodFromMeal(Meal meal) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Food> results = null;

        try {
            Criteria cr = session.createCriteria(Food.class);
            cr.createAlias("meals", "returned_meal");
            cr.add(Restrictions.eq("returned_meal_id", meal.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
