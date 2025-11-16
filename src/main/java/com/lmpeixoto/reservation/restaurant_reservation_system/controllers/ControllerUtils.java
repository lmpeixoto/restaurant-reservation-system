package com.lmpeixoto.reservation.restaurant_reservation_system.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Map;

public class ControllerUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T applyPatch(Map<String, Object> patchPayload, T targetObject, Class<T> clazz) {
        ObjectNode targetNode = objectMapper.convertValue(targetObject, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        targetNode.setAll(patchNode);

        return objectMapper.convertValue(targetNode, clazz);
    }
}
