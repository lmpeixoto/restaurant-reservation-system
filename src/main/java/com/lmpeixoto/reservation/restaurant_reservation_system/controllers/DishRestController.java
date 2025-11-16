package com.lmpeixoto.reservation.restaurant_reservation_system.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Dish;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DishRestController {

    private DishService dishService;

    private ObjectMapper objectMapper;

    @Autowired
    public DishRestController(DishService theDishService, ObjectMapper theObjectMapper) {
        dishService = theDishService;
        objectMapper = theObjectMapper;
    }

    @GetMapping("/dishes")
    public List<Dish> findAll() { return dishService.findAll(); }

    @GetMapping("/dishes/{dishId}")
    public Dish getDish(@PathVariable long dishId) {

        Dish theDish = dishService.findDishById(dishId);

        if (theDish == null) {
            throw new RuntimeException("Dish id not found - " + dishId);
        }

        return theDish;
    }

    @PostMapping("/dishes")
    public Dish addDish(@RequestBody Dish theDish) {

        Dish dbDish = dishService.saveDish(theDish);

        return dbDish;
    }

    @PutMapping("/dishes")
    public Dish updateDish(@RequestBody Dish theDish) {

        Dish dbDish = dishService.saveDish(theDish);

        return dbDish;
    }

    @PatchMapping("/dishes/{dishId}")
    public Dish patchDish(@PathVariable long dishId, @RequestBody Map<String, Object> patchPayload) {

        Dish tempDish = dishService.findDishById(dishId);

        if (tempDish == null) {
            throw new RuntimeException("Dish id not found - " + dishId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Dish id is not allowed in request body - " + dishId);
        }

        Dish patchedDish = ControllerUtils.applyPatch(patchPayload, tempDish, Dish.class);

        Dish dbDish = dishService.saveDish(patchedDish);

        return dbDish;
    }

    @DeleteMapping("/dishes/{dishId}")
    public String deleteDish(@PathVariable long dishId) {

        Dish tempDish = dishService.findDishById(dishId);

        if (tempDish == null) {
            throw new RuntimeException("Dish id not found - " + dishId);
        }

        dishService.deleteDishById(dishId);

        return "Deleted dish id - " + dishId;
    }

}
