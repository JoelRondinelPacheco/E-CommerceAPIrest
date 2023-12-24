package com.joel.spring.utils;

import com.joel.spring.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

@Component
public class CheckOptional {

    public <T> T checkOptionalOk(Optional<T> optional) throws NotFoundException {
        if (optional.isPresent()) {
            return optional.get();
        }
        Class<T> type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        String className = type.getSimpleName();

        throw new NotFoundException(className + " not found");
    }

}
