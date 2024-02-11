package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.application.port.output.UserByIdPort;
import com.joel.spring.user.domain.User;

public class UserSelectorPersistenceAdapter implements UserByIdPort {
    @Override
    public User get(String id) {
        return null;
    }
}
