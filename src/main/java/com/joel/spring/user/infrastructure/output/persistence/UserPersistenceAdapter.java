package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.accounttoken.application.port.output.AuthRepositoryPort;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserPersistenceAdapter implements AuthRepositoryPort {

    @Autowired
    private UserJpaMySQLRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public User register(User user) {
        //TODO REFACTO PARA QUE SEA MAS LEGIBLE
        this.userRepository.findById("asd").orElseThrow();
        return this.mapper.entityToDomain(userRepository.save(this.mapper.domainToEntity(user)));
    }

    @Override
    public User update(User user) {
        //TODO REFACTOR CON UPDATE CUSTOM QUERY
        return this.mapper.entityToDomain(userRepository.save(this.mapper.domainToEntity(user)));
    }
}
