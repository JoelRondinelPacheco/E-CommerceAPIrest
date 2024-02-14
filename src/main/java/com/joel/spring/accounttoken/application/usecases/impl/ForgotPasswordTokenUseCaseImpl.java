package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.usecases.ForgotPasswordTokenUseCase;
import com.joel.spring.user.domain.AccountToken;

public class ForgotPasswordTokenUseCaseImpl implements ForgotPasswordTokenUseCase {
    @Override
    public AccountToken updateToken(AccountToken accountToken) {
        accountToken.setToken("FORGOT-PASSWORD-TOKEN");
        accountToken.setValid(true);
        //TODO set expiration date
        return accountToken;
    }
}
