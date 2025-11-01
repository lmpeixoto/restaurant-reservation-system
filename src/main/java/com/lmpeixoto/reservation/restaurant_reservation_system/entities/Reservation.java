package com.lmpeixoto.reservation.restaurant_reservation_system.entities;

import jakarta.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;



}
//id
//        customerId
//tableId
//        dateTime
//numberOfPeople
//status (Active, Cancelled, Completed)
//createdAt
//        UpdatedAt