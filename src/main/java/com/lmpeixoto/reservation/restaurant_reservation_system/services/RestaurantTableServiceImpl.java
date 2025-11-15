package com.lmpeixoto.reservation.restaurant_reservation_system.services;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.RestaurantTable;
import com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces.RestaurantTableRepository;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    @Autowired
    public RestaurantTableRepository restaurantTableRepository;

    @Override
    public void saveRestaurantTable(RestaurantTable theRestaurantTable) {
        restaurantTableRepository.save(theRestaurantTable);
    }

    @Override
    public List<RestaurantTable> findAll() {
        return StreamSupport.stream(restaurantTableRepository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public RestaurantTable findRestaurantTableById(long theId) {
        Optional<RestaurantTable> result = restaurantTableRepository.findById(theId);

        RestaurantTable theRestaurantTable = null;

        if (result.isPresent()) {
            theRestaurantTable = result.get();
        } else {
            throw new RuntimeException("Did not find RestaurantTable id - " + theId);
        }

        return theRestaurantTable;
    }

    @Override
    public void deleteRestaurantTableById(long theId) {
        restaurantTableRepository.deleteById(theId);
    }
}
