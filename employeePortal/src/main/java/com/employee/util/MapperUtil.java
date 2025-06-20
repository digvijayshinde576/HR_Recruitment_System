package com.employee.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T readValue(String content, Class<T> targetClass) {
        try {
            return objectMapper.readValue(content, targetClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }


    public <S, T> T mapObject(S sourceObject, Class<T> targetClass) {
        return objectMapper.convertValue(sourceObject, targetClass);
    }
}
 
 