package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.application.dto.UserPersonalInfoDTO;
import com.joel.spring.user.application.dto.auth.LoginPersistenceInfoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDTOsJpaMySQLRepository extends JpaRepository<UserEntity, String> {
    @Query(value = "select (u.id, u.password) from user_entity u where u.email = :email", nativeQuery = true)
    Optional<LoginPersistenceInfoDTO> findLoginInfoDTO(@Param("email") String email);

    @Query(value = "select (u.id, u.first_name, u.last_name, u.email) from user_entity u where u.id = :userId", nativeQuery = true)
    Optional<UserPersonalInfoDTO> getUserPersonalInfo(@Param("userId") String userId);

    //@Query("SELECT new com.joel.spring.user.dto.UserPersonalInfoDTO(u.id AS id, u.firstName AS firstName, u.lastName AS lastName, u.email AS email) FROM UserEntity u WHERE u.email = :email")
    @Query(value = "select (u.id, u.first_name, u.last_name, u.email) from user_entity u where u.email = :email", nativeQuery = true)
    Optional<UserPersonalInfoDTO> findByEmail(@Param("email") String email);
    @Query(value = "select (u.id, u.first_name, u.last_name, u.email) from user_entity u", nativeQuery = true)
    List<UserPersonalInfoDTO> getAllDTO();
}
