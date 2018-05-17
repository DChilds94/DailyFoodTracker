package models.consumer;

import models.day.Day;

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

//    @Column(name = "days")
    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }
}

