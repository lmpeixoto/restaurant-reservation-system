package com.lmpeixoto.reservation.restaurant_reservation_system.controllers;

import com.lmpeixoto.reservation.restaurant_reservation_system.dto.ReservationCreateDTO;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Customer;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Reservation;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.RestaurantTable;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.CustomerService;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.ReservationService;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReservationsRestController {

    private final CustomerService customerService;
    private final RestaurantTableService restaurantTableService;
    private ReservationService reservationService;

    @Autowired
    public ReservationsRestController(ReservationService theReservationService, CustomerService customerService, RestaurantTableService restaurantTableService) {
        reservationService = theReservationService;
        this.customerService = customerService;
        this.restaurantTableService = restaurantTableService;
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
    public Reservation addReservation(@RequestBody ReservationCreateDTO dto) {

        Customer customer = customerService.findCustomerById(dto.customerId);

        RestaurantTable restaurantTable = restaurantTableService.findRestaurantTableById(dto.restaurantTableId);

        Reservation dbReservation = new Reservation();

        dbReservation.setNumberOfPeople(dto.numberOfPeople);
        dbReservation.setDateTime(LocalDateTime.parse(dto.dateTime));
        dbReservation.setCustomer(customer);
        dbReservation.setRestaurantTable(restaurantTable);
        dbReservation.setCreatedAt(LocalDateTime.now());

        reservationService.saveReservation(dbReservation);

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
