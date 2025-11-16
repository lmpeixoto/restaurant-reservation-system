package com.lmpeixoto.reservation.restaurant_reservation_system.services;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Reservation;
import com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces.ReservationRepository;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void saveReservation(Reservation theReservation) {
        reservationRepository.save(theReservation);
    }

    @Override
    public List<Reservation> findAll() {
        return StreamSupport.stream(reservationRepository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public Reservation findReservationById(long theId) {
        Optional<Reservation> result = reservationRepository.findById(theId);

        Reservation theReservation = null;

        if (result.isPresent()) {
            theReservation = result.get();
        } else {
            throw new RuntimeException("Did not find Reservation id - " + theId);
        }

        return theReservation;
    }

    @Override
    public void deleteReservationById(long theId) {
        reservationRepository.deleteById(theId);
    }
}
