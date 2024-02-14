package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.application.port.output.UserSelectorPort;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserSelectorPersistenceAdapter implements UserSelectorPort {

    @Autowired
    private JpaMySQLUserRepository userRepository;

    @Override
    public User byEmail(String userEmail) {
        Optional<UserEntity> optional = this.userRepository.findByEmail(userEmail);
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
