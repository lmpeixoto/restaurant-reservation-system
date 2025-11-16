package com.lmpeixoto.reservation.restaurant_reservation_system.services;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Dish;
import com.lmpeixoto.reservation.restaurant_reservation_system.repositories.interfaces.DishRepository;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish saveDish(Dish theDish) {
        dishRepository.save(theDish);
        return theDish;
    }

    @Override
    public List<Dish> findAll() {
        return StreamSupport.stream(dishRepository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public Dish findDishById(long theId) {
        Optional<Dish> result = dishRepository.findById(theId);

        Dish theDish = null;

        if (result.isPresent()) {
            theDish = result.get();
        } else {
            throw new RuntimeException("Did not find Dish id - " + theId);
        }

        return theDish;
    }

    @Override
    public void deleteDishById(long theId) {
        dishRepository.deleteById(theId);
    }
}
