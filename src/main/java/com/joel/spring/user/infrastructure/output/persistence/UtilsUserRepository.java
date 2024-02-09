package com.joel.spring.user.infrastructure.output.persistence;

import org.springframework.data.repository.Repository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UtilsUserRepository extends Repository<UserEntity, String> {

    boolean existsByEmail(String email);
}
