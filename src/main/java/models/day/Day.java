package models.day;

import models.meal.Meal;
import models.consumer.Consumer;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="days")
public class Day {

    private int id;
    private GregorianCalendar date;
    private Set<Meal> meals;
    private Consumer consumer;

    public Day() {
    }

    public Day(GregorianCalendar date, Consumer consumer) {
        this.date = date;
        this.meals = new HashSet<Meal>();
        this.consumer = consumer;
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

    @Column(name = "date")
    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "day")
    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    @ManyToOne
    @JoinColumn(name="consumer_id", nullable = false)
    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}
