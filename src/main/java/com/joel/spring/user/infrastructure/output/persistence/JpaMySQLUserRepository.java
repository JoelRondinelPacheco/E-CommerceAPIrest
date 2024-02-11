package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaMySQLUserRepository extends JpaRepository<UserEntity, String> {

    //@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT new com.joel.spring.dtos.users.UserPersonalInfoDTO(u.id AS id, u.firstName AS firstName, u.lastName AS lastName, u.email AS email) FROM UserEntity u WHERE u.id = :userId")
    Optional<UserPersonalInfoDTO> getUserPersonalInfo(@Param("userId") String userId);
    @Query("SELECT new com.joel.spring.dtos.users.UserPersonalInfoDTO(u.id AS id, u.firstName AS firstName, u.lastName AS lastName, u.email AS email) FROM UserEntity u")
    List<UserPersonalInfoDTO> getAllDTO();
}
