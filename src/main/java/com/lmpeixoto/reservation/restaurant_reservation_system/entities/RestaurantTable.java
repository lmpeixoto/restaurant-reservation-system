package com.lmpeixoto.reservation.restaurant_reservation_system.entities;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.enums.TableStatus;
import jakarta.persistence.*;


@Entity
@Table(name = "restaurant_table")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "table_status")
    private TableStatus tableStatus;

    public RestaurantTable() {

    }

    public RestaurantTable(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "RestaurantTable{" +
                "id=" + id +
                ", number=" + number +
                ", capacity=" + capacity +
                ", tableStatus=" + tableStatus +
                '}';
    }
}



