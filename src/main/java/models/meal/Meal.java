package models.meal;

import models.food.Food;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Meal {

    private int id;
    private MealType meal;
    private Set<Food> foods;

    public Meal() {
    }

    public Meal(MealType meal) {
        this.meal = meal;
        this.foods = new HashSet<Food>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MealType getMeal() {
        return meal;
    }

    public void setMeal(MealType meal) {
        this.meal = meal;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="food_meals", joinColumns = {@JoinColumn(name="meal_id", nullable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name="food_id", nullable = false, updatable = false)}
    )
    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
}
