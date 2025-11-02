package com.lmpeixoto.reservation.restaurant_reservation_system.dao.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.RestaurantTable;

public interface RestaurantTableDAO {

    void save(RestaurantTable theRestaurantTable);

    RestaurantTable findTableById(int theId);

    void delete(int theId);
}
