package com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Dish;

import java.util.List;

public interface DishService {

    void saveDish(Dish theDish);

    List<Dish> findAll();

    Dish findDishById(long theId);

    void deleteDishById(long theId);

}
