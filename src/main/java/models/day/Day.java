package models.day;

import models.meal.Meal;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Day {

    private int id;
    private GregorianCalendar date;
    private Set<Meal> meals;

    public Day() {
    }

    public Day(GregorianCalendar date) {
        this.date = date;
        this.meals = new HashSet<Meal>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }
}
