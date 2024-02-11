package com.example.exceptions.services;

import com.example.exceptions.dto.Genre;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class EnumInfoProvider {

    public String getFriendlyName(Class<?> clazz) {
        if (clazz.equals(Genre.class)) {
            return "genre";
        }
        return clazz.getName();
    }

    public String getValidValues(Class<?> clazz) {
        if (clazz.isEnum()) {
            return Arrays.stream(clazz.getEnumConstants())
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
        }
        return "?";
    }

}
