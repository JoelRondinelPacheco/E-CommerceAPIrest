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
        return this.tokenRepository.getById(id);
    }

    @Override
    public AccountToken getByToken(String token) {
        return this.tokenRepository.getByToken(token);
    }

    @Override
    public AccountToken getByUserEmail(String userEmail) {
        return this.tokenRepository.getByUserEmail(userEmail);
    }
}
