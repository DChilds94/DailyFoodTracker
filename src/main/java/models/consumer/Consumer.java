package models.consumer;

import db.DBHelper;
import models.day.Day;
import models.food.Food;
import models.meal.Meal;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "consumers")
public class Consumer {

    private int id;
    private String name;
    private Set<Day> days;

    public Consumer() {
    }

    public Consumer(String name) {
        this.name = name;
        this.days = new HashSet<Day>();
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

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "consumer")
        public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }

    public void addDay(Day day) {
        this.days.add(day);
    }

    public void logFood(Day day, Meal meal, Food food) {
        this.addDay(day);
        day.addMeal(meal);
        meal.addFood(food);
        food.addMeal(meal);
        DBHelper.save(meal);

    }

}

