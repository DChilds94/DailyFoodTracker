package models.consumer;

import models.day.Day;

import java.util.HashSet;
import java.util.Set;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }
}

