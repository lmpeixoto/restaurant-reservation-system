package com.lmpeixoto.reservation.restaurant_reservation_system.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String description;

    private List<String> ingredients;

    @Column(nullable = false)
    private boolean available;

    private enum category {
        MAIN_COURSE, DESSERT, APPETIZER
    }

    public Dish() {

    }

    public Dish(int id, String name, String description, List<String> ingredients, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.available = available;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}