package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.application.port.output.AuthRepositoryPort;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserPersistenceAdapter implements AuthRepositoryPort {

    @Autowired
    private JpaMySQLUserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public User register(User user) {
        //TODO REFACTO PARA QUE SEA MAS LEGIBLE
        return this.mapper.entityToDomain(userRepository.save(this.mapper.domainToEntity(user)));
    }

    @Override
    public User registrationUpdate(User user) {
        //TODO REFACTOR CON UPDATE CUSTOM QUERY
        return this.mapper.entityToDomain(userRepository.save(this.mapper.domainToEntity(user)));
    }

    @Override
    public User getUserByEmail(String email) {
        //TODO REFACTOR CON CLEAN CODE
        Optional<UserEntity> userEntity = this.userRepository.findByEmail(email);
        if (userEntity.isPresent()) {
            return this.mapper.entityToDomain(userEntity.get());
        }
        throw new RuntimeException("TODO CREATE CUSTOM EXCEPTION");
    }
}
