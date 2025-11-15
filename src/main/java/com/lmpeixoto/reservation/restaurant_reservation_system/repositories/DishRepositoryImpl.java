package com.lmpeixoto.reservation.restaurant_reservation_system.repositories;

import com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces.DishRepository;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Dish;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DishRepositoryImpl implements DishRepository {

    private EntityManager entityManager;

    @Autowired
    public DishRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Dish theDish) {
        entityManager.persist(theDish);
    }

    @Override
    public Dish findDishById(int theId) {
        return entityManager.find(Dish.class, theId);
    }

    @Override
    public Dish findDishByName(String name) {
        return entityManager.find(Dish.class, name);
    }

    @Override
    @Transactional
    public void deleteDishById(int theId) {

        Dish tempDish = entityManager.find(Dish.class, theId);

        entityManager.remove(tempDish);
    }
}
