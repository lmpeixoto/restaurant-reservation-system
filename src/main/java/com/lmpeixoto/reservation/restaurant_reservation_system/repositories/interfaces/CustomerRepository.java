package com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
