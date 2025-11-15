package com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.RestaurantTable;

public interface RestaurantTableRepository {

    void save(RestaurantTable theRestaurantTable);

    RestaurantTable findTableById(int theId);

    void delete(int theId);
}
