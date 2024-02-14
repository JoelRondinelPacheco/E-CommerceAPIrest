package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.application.dto.UserPersonalInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaMySQLRepository extends JpaRepository<UserEntity, String> {

    //@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);


}
