package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.port.input.TokenSelector;
import com.joel.spring.accounttoken.application.port.output.TokenSelectorPort;
import com.joel.spring.user.domain.AccountToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("accountTokenByToken")
public class AccountTokenSelectorByToken implements TokenSelector<String> {

    @Autowired
    private TokenSelectorPort<String> tokenRepository;

    @Override
    public AccountToken get(String token) {
        return this.tokenRepository.get(token);
    }
}
