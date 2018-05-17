package db;

import models.food.Food;
import models.meal.Meal;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFood {

    private static Session session;

    public static List<Meal> getMealsFromFood(Food food) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> results = null;
        try {
            Criteria cr = session.createCriteria(Meal.class);
            cr.createAlias("foods", "returned_food");
            cr.add(Restrictions.eq("returned_food_id", food.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
