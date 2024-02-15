package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.usecases.ForgotPasswordTokenUseCase;
import com.joel.spring.user.domain.AccountToken;
import org.springframework.stereotype.Component;

@Component
public class ForgotPasswordTokenUseCaseImpl implements ForgotPasswordTokenUseCase {
    @Override
    public AccountToken updateToken(AccountToken accountToken) {
        accountToken.setToken("FORGOT-PASSWORD-TOKEN");
        accountToken.setValid(true);
        //TODO set expiration date
        return accountToken;
    }
}
