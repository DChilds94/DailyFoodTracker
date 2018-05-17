package db;

import models.day.Day;
import models.food.Food;
import models.meal.Meal;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDay {

    private static Session session;


    public static List<Meal> getMealFromDay(Day day) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> results = null;

        try {
            Criteria cr = session.createCriteria(Meal.class);
            cr.add(Restrictions.eq("day", day));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
