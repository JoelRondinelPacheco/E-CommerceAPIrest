package com.joel.spring.user.infrastructure.output.persistence.accounttoken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMySQLAccountTokenRepository extends JpaRepository<AccountTokenEntity, String> {

    Optional<AccountTokenEntity> findByToken(String token);
}
