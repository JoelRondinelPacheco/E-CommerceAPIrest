package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.port.input.TokenSelector;
import com.joel.spring.accounttoken.application.port.output.TokenSelectorPort;
import com.joel.spring.accounttoken.domain.AccountToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenSelectorImpl implements TokenSelector {

    @Autowired
    private TokenSelectorPort tokenRepository;

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
