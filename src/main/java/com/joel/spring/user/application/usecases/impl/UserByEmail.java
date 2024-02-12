package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("userByEmail")
public class UserByEmail implements UserSelector<String> {

    // interfaz con metodo
    @Override
    public User get(String user) {
        return null;
    }
}
