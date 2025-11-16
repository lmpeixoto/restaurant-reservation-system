package com.lmpeixoto.reservation.restaurant_reservation_system.controllers;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Reservation;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReservationsRestController {

    private ReservationService reservationService;

    @Autowired
    public ReservationsRestController(ReservationService theReservationService) {
        reservationService = theReservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> findAll() { return reservationService.findAll(); }

    @GetMapping("/reservations/{reservationId}")
    public Reservation getReservation(@PathVariable long reservationId) {

        Reservation theReservation = reservationService.findReservationById(reservationId);

        if (theReservation == null) {
            throw new RuntimeException("Reservation id not found - " + reservationId);
        }

        return theReservation;

    }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation theReservation) {

        Reservation dbReservation = reservationService.saveReservation(theReservation);

        return dbReservation;
    }

    @PutMapping("/reservations/{reservationId}")
    public Reservation updateReservation(@PathVariable long reservationId, @RequestBody Map<String, Object> patchPayload) {

        Reservation tempReservation = reservationService.findReservationById(reservationId);

        if (tempReservation == null) {
            throw new RuntimeException("Reservation id not found - " + reservationId);

        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Reservation id is not allowed in request body - " + reservationId);
        }

        Reservation patchedReservation = ControllerUtils.applyPatch(patchPayload, tempReservation, Reservation.class);

        Reservation dbReservation = reservationService.saveReservation(patchedReservation);

        return dbReservation;

    }

    @DeleteMapping("/reservations/{reservationId}")
    public String deleteReservation(@PathVariable long reservationId) {

        Reservation tempReservation = reservationService.findReservationById(reservationId);

        if (tempReservation == null) {

            throw new RuntimeException("Reservation id not found - " + reservationId);

        }

        reservationService.deleteReservationById(reservationId);

        return "Deleted reservation id - " + reservationId;
    }


}
