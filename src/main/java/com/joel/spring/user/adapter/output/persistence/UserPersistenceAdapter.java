package com.joel.spring.user.adapter.output.persistence;

import com.joel.spring.user.application.port.output.AuthRepositoryPort;
import com.joel.spring.user.domain.User;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceAdapter implements AuthRepositoryPort {

    @Autowired
    private UserJpaMySQLRepository userRepository;

    @Autowired
    @Qualifier("userMapper")
    private Mapper<UserEntity, User> mapper;

    @Override
    public User register(User user) {
        UserEntity userSaved = this.userRepository.save(this.mapper.domainToEntity(user));
        return this.mapper.entityToDomain(userSaved);
    }

    @Override
    public User update(User user) {
        //TODO REFACTOR CON UPDATE CUSTOM QUERY
        return this.mapper.entityToDomain(userRepository.save(this.mapper.domainToEntity(user)));
    }
}
