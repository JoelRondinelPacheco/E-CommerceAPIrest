package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.domain.User;

public class UserMapper {
    public static User entityToDomain(UserEntity userEntity) {
        User user = new User();
        return user;
    }

    public static UserEntity domainToEntity(User user) {
        UserEntity userEntity = new UserEntity();

        return userEntity;
    }
}
