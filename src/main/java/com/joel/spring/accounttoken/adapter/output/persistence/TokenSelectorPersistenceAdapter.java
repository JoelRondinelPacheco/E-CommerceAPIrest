package com.joel.spring.accounttoken.adapter.output.persistence;

import com.joel.spring.accounttoken.application.port.output.TokenSelectorPort;
import com.joel.spring.user.domain.AccountToken;
import org.springframework.stereotype.Component;

@Component
public class TokenSelectorPersistenceAdapter implements TokenSelectorPort {
    @Override
    public AccountToken getById(String id) {
        return null;
    }

    @Override
    public AccountToken getByToken(String token) {
        return null;
    }

    @Override
    public AccountToken getByUserEmail(String userEmail) {
        return null;
    }
}
