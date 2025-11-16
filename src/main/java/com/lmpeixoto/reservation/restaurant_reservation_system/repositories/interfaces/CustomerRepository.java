package com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
