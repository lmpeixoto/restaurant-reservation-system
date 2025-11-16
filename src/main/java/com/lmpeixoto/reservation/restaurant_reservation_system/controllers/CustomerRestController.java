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

    @Autowired
    public CustomerRestController(CustomerService theCustomerService) {
        customerService = theCustomerService;
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

        Customer patchedCustomer = ControllerUtils.applyPatch(patchPayload, tempCustomer, Customer.class);

        Customer dbCustomer = customerService.saveCustomer(patchedCustomer);

        return dbCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable long customerId) {

        Customer tempCustomer = customerService.findCustomerById(customerId);

        if (tempCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        customerService.deleteCustomerById(customerId);

        return "Deleted customer id - " + customerId;
    }

}
