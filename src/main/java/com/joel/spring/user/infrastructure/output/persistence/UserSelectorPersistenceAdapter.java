package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.application.port.output.UserSelectorPort;
import com.joel.spring.user.domain.User;

public class UserSelectorPersistenceAdapter implements UserSelectorPort {

    @Override
    public User byEmail(String userEmail) {
        return null;
    }

    @Override
    public User byId(String userId) {
        return null;
    }

    @Override
    public User byAccountToken(String accountToken) {
        return null;
    }
}
