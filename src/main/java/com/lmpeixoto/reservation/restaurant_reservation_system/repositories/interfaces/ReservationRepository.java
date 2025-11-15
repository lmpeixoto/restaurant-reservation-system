package com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Reservation;

public interface ReservationRepository {

    void save(Reservation theReservation);

    Reservation findReservationById(int theId);

    void deleteReservationById(int theId);
}
