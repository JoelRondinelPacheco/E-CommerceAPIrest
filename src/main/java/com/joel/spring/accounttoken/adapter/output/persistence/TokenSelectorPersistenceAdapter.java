package com.joel.spring.accounttoken.adapter.output.persistence;

import com.joel.spring.accounttoken.application.port.output.TokenSelectorPort;
import com.joel.spring.accounttoken.domain.AccountToken;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TokenSelectorPersistenceAdapter implements TokenSelectorPort {

    @Autowired
    private AccountTokenMySQLRepository accountTokenRepository;
    @Autowired
    @Qualifier("accountTokenMapper")
    private Mapper<AccountTokenEntity, AccountToken> mapper;

    @Override
    public AccountToken getById(String id) {
        return this.accountTokenRepository.findById(id).map(this.mapper::entityToDomain).orElseThrow();
    }

    @Override
    public AccountToken getByToken(String token) {
        return this.accountTokenRepository.findByToken(token).map(this.mapper::entityToDomain).orElseThrow();
    }

    @Override
    public AccountToken getByUserEmail(String userEmail) {
        return this.accountTokenRepository.findByUserEmail(userEmail).map(this.mapper::entityToDomain).orElseThrow();
    }
}
