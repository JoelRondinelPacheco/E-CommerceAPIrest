package com.joel.spring.user.application.usecases.accounttoken.impl;

import com.joel.spring.user.application.usecases.accounttoken.ForgotPasswordTokenUseCase;
import com.joel.spring.user.domain.AccountToken;

public class ForgotPasswordTokenUseCaseImpl implements ForgotPasswordTokenUseCase {
    @Override
    public AccountToken updateToken(AccountToken accountToken) {
        accountToken.setToken("FORGOT-PASSWORD-TOKEN");
        accountToken.setValid(true);
        //TODO set invalid date
        return accountToken;
    }
}
