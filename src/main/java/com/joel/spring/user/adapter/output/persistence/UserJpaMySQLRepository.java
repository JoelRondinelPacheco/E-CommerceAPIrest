package com.joel.spring.user.adapter.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaMySQLRepository extends JpaRepository<UserEntity, String> {

    //@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);


}
