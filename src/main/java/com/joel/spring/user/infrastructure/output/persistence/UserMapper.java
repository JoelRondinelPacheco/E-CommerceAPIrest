package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.domain.User;

public class UserMapper {
    public User entityToDomain(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        return user;
    }

    public UserEntity domainToEntity(User user) {
        UserEntity userEntity = new UserEntity();

        return userEntity;
    }
}
