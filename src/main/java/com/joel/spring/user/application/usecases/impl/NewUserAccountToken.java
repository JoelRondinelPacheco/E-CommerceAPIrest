package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.usecases.AccountTokenUseCase;
import com.joel.spring.user.domain.AccountToken;

public class NewUserAccountToken implements AccountTokenUseCase {

    @Override
    public AccountToken create() {
        String token = "Generate random token or jwt";
        return AccountToken.NewUserAccountToken(token);
    }
}
