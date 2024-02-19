package com.joel.spring.user.adapter.output.persistence;

import com.joel.spring.user.application.port.output.UserSelectorPort;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserSelectorPersistenceAdapter implements UserSelectorPort {

    @Autowired
    private UserJpaMySQLRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public User byEmail(String userEmail) {
        Optional<UserEntity> optional = this.userRepository.findByEmail(userEmail);
        if(optional.isPresent()) {
            return this.mapper.entityToDomain(optional.get());
        }
        throw new RuntimeException("EX");
    }

    @Override
    public User byId(String userId) {

        Optional<UserEntity> optional = this.userRepository.findById(userId);
        return null;
    }

    @Override
    public User byAccountToken(String accountToken) {
        return null;
    }
}
