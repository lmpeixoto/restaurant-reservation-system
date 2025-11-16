package com.lmpeixoto.reservation.restaurant_reservation_system.services;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Customer;
import com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces.CustomerRepository;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);

        return theCustomer;
    }

    @Override
    public List<Customer> findAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public Customer findCustomerById(long theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer theCustomer = null;

        if (result.isPresent()) {
            theCustomer = result.get();
        } else {
            throw new RuntimeException("Did not find Customer id - " + theId);
        }

        return theCustomer;
    }

    @Override
    public void deleteCustomerById(long theId) {
        customerRepository.deleteById(theId);
    }
}
