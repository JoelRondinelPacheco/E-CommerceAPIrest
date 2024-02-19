package com.joel.spring.accounttoken.adapter.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountTokenMySQLRepository extends JpaRepository<AccountTokenEntity, String> {

    Optional<AccountTokenEntity> findByToken(String token);

    //TODO VER SI FUNCIONA
    @Query("SELECT u.accountToken FROM UserEntity u WHERE u.email = :email")
    Optional<AccountTokenEntity> findByUserEmail(@Param("email") String email);
}
