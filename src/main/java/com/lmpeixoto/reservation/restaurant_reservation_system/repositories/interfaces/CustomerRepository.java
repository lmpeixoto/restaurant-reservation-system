package com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Customer;

public interface CustomerRepository {

    void save(Customer theCustomer);

    Customer findCustomerById(int theId);

    Customer findCustomerByEmail(String email);

    Customer findCustomerByPhone(int phone);

    void deleteCustomerById(int theId);
}
