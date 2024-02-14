package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.application.dto.auth.LoginPersistenceInfoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserDTOsJpaMySQLRepository extends Repository<UserEntity, String> {
    @Query(value = "select (u.id, u.password) from user_entity u where u.email = :email", nativeQuery = true)
    Optional<LoginPersistenceInfoDTO> findLoginInfoDTO(@Param("email") String email);
}
