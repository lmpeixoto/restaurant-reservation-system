package com.lmpeixoto.reservation.restaurant_reservation_system.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Customer;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    private ObjectMapper objectMapper;

    @Autowired
    public CustomerRestController(CustomerService theCustomerService, ObjectMapper theObjectMapper) {
        customerService = theCustomerService;
        objectMapper = theObjectMapper;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable long customerId) {

        Customer theCustomer = customerService.findCustomerById(customerId);

        if (theCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        Customer dbCustomer = customerService.saveCustomer(theCustomer);

        return dbCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {

        Customer dbCustomer = customerService.saveCustomer(theCustomer);

        return dbCustomer;
    }

    @PatchMapping("/customers/{customerId}")
    public Customer patchCustomer(@PathVariable long customerId, @RequestBody Map<String, Object> patchPayload) {

        Customer tempCustomer = customerService.findCustomerById(customerId);

        if (tempCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Customer id is not allowed in request body - " + customerId);
        }

        Customer patchedCustomer = apply(patchPayload, tempCustomer);

        Customer dbCustomer = customerService.saveCustomer(patchedCustomer);

        return dbCustomer;
    }

    private Customer apply(Map<String, Object> patchPayload, Customer tempCustomer) {
        ObjectNode customerNode = objectMapper.convertValue(tempCustomer, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        customerNode.setAll(patchNode);

        return objectMapper.convertValue(customerNode, Customer.class);
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteEmployee(@PathVariable long customerId) {

        Customer tempCustomer = customerService.findCustomerById(customerId);

        if (tempCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        customerService.deleteCustomerById(customerId);

        return "Deleted customer id - " + customerId;
    }

}

