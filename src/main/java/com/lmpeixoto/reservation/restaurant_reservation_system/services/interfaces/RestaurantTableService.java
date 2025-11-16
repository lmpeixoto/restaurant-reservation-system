package com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.RestaurantTable;

import java.util.List;

public interface RestaurantTableService {

    RestaurantTable saveRestaurantTable(RestaurantTable theRestaurantTable);

    List<RestaurantTable> findAll();

    RestaurantTable findRestaurantTableById(long theId);

    void deleteRestaurantTableById(long theId);
}
