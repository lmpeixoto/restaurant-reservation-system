package com.lmpeixoto.reservation.restaurant_reservation_system.entities;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.enums.ReservationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private long id;

    @Column(nullable = false)
    private int numberOfPeople;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private RestaurantTable restaurantTable;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Reservation() {

    }

    public Reservation(int numberOfPeople, LocalDateTime dateTime, RestaurantTable restaurantTable, Customer customer, ReservationStatus reservationStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.numberOfPeople = numberOfPeople;
        this.dateTime = dateTime;
        this.restaurantTable = restaurantTable;
        this.customer = customer;
        this.reservationStatus = reservationStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", numberOfPeople=" + numberOfPeople +
                ", dateTime=" + dateTime +
                ", restaurantTable=" + restaurantTable +
                ", customer=" + customer +
                ", reservationStatus=" + reservationStatus +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
