package com.lmpeixoto.reservation.restaurant_reservation_system.dao.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Reservation;

public interface ReservationDAO {

    void save(Reservation theReservation);

    Reservation findReservationById(int theId);

    void deleteReservationById(int theId);
}
