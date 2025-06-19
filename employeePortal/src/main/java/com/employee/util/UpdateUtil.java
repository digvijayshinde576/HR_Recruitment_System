package com.employee.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class UpdateUtil {
    private static final ObjectMapper objectMapper=new ObjectMapper();

    private UpdateUtil(ObjectMapper objectMapper) {

    }

    public static JsonNode getJsonNode(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (Exception e) {
            return null;
        }
    } public static <T> T readValue(String content, Class<T> clazz) {
        try {
            return objectMapper.readValue(content, clazz);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
