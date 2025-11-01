package com.lmpeixoto.reservation.restaurant_reservation_system.entities;

import jakarta.persistence.*;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private int capacity;

    @Enumerated(EnumType.STRING)
    private TableStatus tableStatus;

    public Table() {

    }

    public Table(int id, int number, int capacity) {
        this.id = id;
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
}

