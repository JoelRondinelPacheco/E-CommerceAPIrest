package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.application.port.output.UserSelectorPort;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSelectorImpl implements UserSelector {

    @Autowired
    private UserSelectorPort userRepository;

    @Override
    public User byEmail(String userEmail) {
        return this.userRepository.byEmail(userEmail);
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
