package com.lmpeixoto.reservation.restaurant_reservation_system.dao;

import com.lmpeixoto.reservation.restaurant_reservation_system.dao.interfaces.RestaurantTableDAO;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.RestaurantTable;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantTableDAOImpl implements RestaurantTableDAO {

    public EntityManager entityManager;

    @Autowired
    public RestaurantTableDAOImpl(EntityManager entityManager) {
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
