package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.application.dto.UserPersonalInfoDTO;
import com.joel.spring.user.application.dto.auth.LoginPersistenceInfoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserDTOsJpaMySQLRepository extends Repository<UserEntity, String> {
    @Query(value = "select (u.id, u.password) from user_entity u where u.email = :email", nativeQuery = true)
    Optional<LoginPersistenceInfoDTO> findLoginInfoDTO(@Param("email") String email);

    @Query("SELECT new com.joel.spring.user.dto.UserPersonalInfoDTO(u.id AS id, u.firstName AS firstName, u.lastName AS lastName, u.email AS email) FROM UserEntity u WHERE u.id = :userId")
    Optional<UserPersonalInfoDTO> getUserPersonalInfo(@Param("userId") String userId);
    @Query("SELECT new com.joel.spring.user.dto.UserPersonalInfoDTO(u.id AS id, u.firstName AS firstName, u.lastName AS lastName, u.email AS email) FROM UserEntity u")
    List<UserPersonalInfoDTO> getAllDTO();
}
