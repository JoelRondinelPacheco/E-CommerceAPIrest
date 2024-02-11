package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userReferenceById")
public class UserReferenceById implements UserSelector<String> {
    @Override
    public User get(String id) {
        return null;
    }
}
