package com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.RestaurantTable;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantTableRepository extends CrudRepository<RestaurantTable, Long> {
}
