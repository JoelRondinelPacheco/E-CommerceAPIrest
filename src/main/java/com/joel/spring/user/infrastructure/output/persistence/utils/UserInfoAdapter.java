package com.joel.spring.user.infrastructure.output.persistence.utils;

import com.joel.spring.user.application.port.output.UserInfoByEmailPort;
import com.joel.spring.user.domain.User;
import com.joel.spring.user.infrastructure.output.persistence.JpaMySQLUserRepository;
import com.joel.spring.user.infrastructure.output.persistence.UserEntity;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

public class UserInfoAdapter implements UserInfoByEmailPort {

    @Autowired
    private JpaMySQLUserRepository userRepository;
    @Autowired
    @Qualifier("userMapper")
    private Mapper<UserEntity, User> mapper;

    @Override
    public User get(String email) {
        Optional<UserEntity> userEntity = this.userRepository.findByEmail(email);
        if (userEntity.isPresent()) {
            return this.mapper.entityToDomain(userEntity.get());
        }
        //TODO
        throw new RuntimeException("TODO CUSTOM EX");
    }
}
