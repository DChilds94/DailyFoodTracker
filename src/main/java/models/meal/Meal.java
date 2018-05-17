package models.meal;

import models.day.Day;
import models.food.Food;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meals")
public class Meal {

    private int id;
    private MealType meal;
    private Set<Food> foods;
    private Day day;

    public Meal() {
    }

    public Meal(MealType meal, Day day) {
        this.meal = meal;
        this.foods = new HashSet<Food>();
        this.day = day;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="meal_type")
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

    @ManyToOne
    @JoinColumn(name="day_id", nullable = false)
    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }
}
