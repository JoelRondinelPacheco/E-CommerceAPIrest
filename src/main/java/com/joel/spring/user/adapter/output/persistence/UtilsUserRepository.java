package com.joel.spring.user.adapter.output.persistence;

import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface UtilsUserRepository extends Repository<UserEntity, String> {

    boolean existsByEmail(String email);
}
