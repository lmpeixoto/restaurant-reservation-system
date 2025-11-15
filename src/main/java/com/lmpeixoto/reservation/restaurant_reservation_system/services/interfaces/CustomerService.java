package com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void saveCustomer(Customer theCustomer);

    List<Customer> findAll();

    Customer findCustomerById(long theId);

    void deleteCustomerById(long theId);
}
