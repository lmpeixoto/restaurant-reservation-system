package com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Reservation;

import java.util.List;

public interface ReservationService {

    void saveReservation(Reservation theReservation);

    List<Reservation> findAll();

    Reservation findReservationById(long theId);

    void deleteReservationById(long theId);
}
