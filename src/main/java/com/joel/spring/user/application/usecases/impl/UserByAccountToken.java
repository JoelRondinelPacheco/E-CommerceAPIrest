package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.application.port.output.UserByAccountTokenPort;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("userByAccountToken")
public class UserByAccountToken implements UserSelector<String> {

    @Autowired
    private UserByAccountTokenPort userRepository;

    @Override
    public User get(String accountToken) {
        return this.userRepository.get(accountToken);
    }
}
