package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.domain.User;

public class UserSelectorImpl implements UserSelector {

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

    @Override
    public User referenceById(String id) {
        return null;
    }
}
