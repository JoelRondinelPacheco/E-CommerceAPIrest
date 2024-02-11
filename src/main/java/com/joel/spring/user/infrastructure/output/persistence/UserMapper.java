package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.domain.User;
import com.joel.spring.utils.Mapper;

public class UserMapper implements Mapper<UserEntity, User> {
    @Override
    public User entityToDomain(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        return user;
    }

    @Override
    public UserEntity domainToEntity(User user) {
        UserEntity userEntity = new UserEntity();

        return userEntity;
    }
}
