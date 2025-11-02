package com.lmpeixoto.reservation.restaurant_reservation_system.dao.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Dish;

public interface DishDAO {

    void save(Dish theDish);

    Dish findDishById(int theId);

    Dish findDishByName(String name);

    void deleteDishById(int theId);

}
