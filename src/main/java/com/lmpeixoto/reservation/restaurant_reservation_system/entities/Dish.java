package com.lmpeixoto.reservation.restaurant_reservation_system.entities;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.enums.DishCategory;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ElementCollection
    @CollectionTable(name="dish_ingredients", joinColumns = @JoinColumn(name="dish_id"))
    @Column(name = "ingredient")
    private List<String> ingredients;

    @Column(name = "available", nullable = false)
    private boolean available;

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_category")
    private DishCategory dishCategory;

    public Dish() {

    }

    public Dish(String name, String description, List<String> ingredients, boolean available) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", available=" + available +
                ", dishCategory=" + dishCategory +
                '}';
    }
}
