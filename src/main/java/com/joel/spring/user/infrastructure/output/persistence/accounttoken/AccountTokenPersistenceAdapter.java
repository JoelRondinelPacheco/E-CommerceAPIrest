package com.joel.spring.user.infrastructure.output.persistence.accounttoken;

import com.joel.spring.user.application.port.output.AccountTokenRepository;
import com.joel.spring.user.application.port.output.NewAccountTokenPort;
import com.joel.spring.user.domain.AccountToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AccountTokenPersistenceAdapter implements AccountTokenRepository, NewAccountTokenPort {

    @Autowired
    private JpaMySQLAccountTokenRepository accountTokenRepository;

    @Autowired
    private AccountTokenMapper mapper;

    @Override
    public AccountToken getBy(String token) {
        Optional<AccountTokenEntity> accountToken = this.accountTokenRepository.findByToken(token);

        if (accountToken.isPresent()) {
            return this.mapper.entityToDomain(accountToken.get());
        }
        throw new RuntimeException("TODO CUSTOM EXCEPTION");
    }

    @Override
    public AccountToken save(AccountToken accountToken) {
        return null;
    }
}
