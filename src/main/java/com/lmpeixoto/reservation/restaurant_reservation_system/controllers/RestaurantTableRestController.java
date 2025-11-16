package com.lmpeixoto.reservation.restaurant_reservation_system.controllers;

import com.lmpeixoto.reservation.restaurant_reservation_system.entities.RestaurantTable;
import com.lmpeixoto.reservation.restaurant_reservation_system.services.interfaces.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api")
public class RestaurantTableRestController {

    private RestaurantTableService restaurantTableService;

    @Autowired
    public RestaurantTableRestController(RestaurantTableService theRestaurantTableService) {
        restaurantTableService = theRestaurantTableService;
    }

    @GetMapping("/tables")
    public List<RestaurantTable> findAll() {
        return restaurantTableService.findAll();
    }

    @GetMapping("/tables/{tableId}")
    public RestaurantTable getTable(@PathVariable long tableId) {

        RestaurantTable theRestaurantTable = restaurantTableService.findRestaurantTableById(tableId);

        if (theRestaurantTable == null) {
            throw new RuntimeException("Table id not found - " + tableId);
        }

        return theRestaurantTable;
    }

    @PostMapping("/tables")
    public RestaurantTable addTable(@RequestBody RestaurantTable restaurantTable) {

        RestaurantTable dbRestaurantTable = restaurantTableService.saveRestaurantTable(restaurantTable);

        return dbRestaurantTable;
    }

    @PutMapping("/tables")
    public RestaurantTable updateTable(@RequestBody RestaurantTable restaurantTable) {

        RestaurantTable dbRestaurantTable = restaurantTableService.saveRestaurantTable(restaurantTable);

        return dbRestaurantTable;
    }

    @PatchMapping("/tables/{tableId}")
    public RestaurantTable patchTable(@RequestBody Map<String, Object> patchPayload, @PathVariable long tableId) {

        RestaurantTable tempRestaurantTable = restaurantTableService.findRestaurantTableById(tableId);

        if (tempRestaurantTable == null) {
            throw new RuntimeException("Table id not found - " + tableId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Table id is not allowed in request body - " + tableId);
        }

        RestaurantTable patchedRestaurantTable = ControllerUtils.applyPatch(patchPayload, tempRestaurantTable, RestaurantTable.class);

        RestaurantTable dbRestaurantTable = restaurantTableService.saveRestaurantTable(patchedRestaurantTable);

        return dbRestaurantTable;
    }

    @DeleteMapping("/tables/{tableId}")
    public String deleteRestaurantTable(@PathVariable long tableId) {

        RestaurantTable tempRestaurantTable = restaurantTableService.findRestaurantTableById(tableId);

        if (tempRestaurantTable == null) {
            throw new RuntimeException("Table id not found - " + tableId);
        }

        restaurantTableService.deleteRestaurantTableById(tableId);

        return "Deleted table id - " + tableId;

    }

}
