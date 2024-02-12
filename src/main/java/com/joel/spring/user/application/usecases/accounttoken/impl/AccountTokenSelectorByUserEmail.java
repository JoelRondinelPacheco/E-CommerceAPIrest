package com.joel.spring.user.application.usecases.accounttoken.impl;

import com.joel.spring.user.application.port.input.TokenSelector;
import com.joel.spring.user.application.port.output.TokenSelectorPort;
import com.joel.spring.user.domain.AccountToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tokenByUserEmail")
public class AccountTokenSelectorByUserEmail implements TokenSelector<String> {
    @Autowired
    private TokenSelectorPort<String> tokenSelectorPort;

    @Override
    public AccountToken get(String s) {
        return null;
    }
}
