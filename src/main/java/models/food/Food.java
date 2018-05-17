package models.food;

import models.meal.Meal;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Food {

    private int id;
    private String name;
    private int kcal;
    private Set<Meal> meals;

    public Food() {
    }

    public Food(String name, int kcal) {
        this.name = name;
        this.kcal = kcal;
        this.meals = new HashSet<Meal>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "kcal")
    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "food_meals", joinColumns = {@JoinColumn(name="food_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="meal_id", nullable = false, updatable = false)})
    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }
}
