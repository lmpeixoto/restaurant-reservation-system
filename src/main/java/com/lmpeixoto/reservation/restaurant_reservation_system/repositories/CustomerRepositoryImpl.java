package com.lmpeixoto.reservation.restaurant_reservation_system.repositories;

import com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces.CustomerRepository;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Customer;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private EntityManager entityManager;

    @Autowired
    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Customer theCustomer) {
        entityManager.persist(theCustomer);
    }

    @Override
    public Customer findCustomerById(int theId) {
        return entityManager.find(Customer.class, theId);
    }

    @Override
    public Customer findCustomerByEmail(String theEmail) {
        return entityManager.find(Customer.class, theEmail);
    }

    @Override
    public Customer findCustomerByPhone(int thePhone) {
        return entityManager.find(Customer.class, thePhone);
    }

    @Override
    public void deleteCustomerById(int theId) {

        Customer tempCustomer = entityManager.find(Customer.class, theId);

        entityManager.remove(tempCustomer);
    }
}
