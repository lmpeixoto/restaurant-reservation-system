package com.lmpeixoto.reservation.restaurant_reservation_system.repositories;

import com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces.RestaurantTableRepository;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.RestaurantTable;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantTableRepositoryImpl implements RestaurantTableRepository {

    public EntityManager entityManager;

    @Autowired
    public RestaurantTableRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(RestaurantTable theRestaurantTable) {
        entityManager.persist(theRestaurantTable);
    }

    @Override
    public RestaurantTable findTableById(int theId) {
        return entityManager.find(RestaurantTable.class, theId);
    }

    @Override
    public void delete(int theId) {

        RestaurantTable tempRestaurantTable = entityManager.find(RestaurantTable.class, theId);

        entityManager.remove(tempRestaurantTable);

    }
}
