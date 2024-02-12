package com.joel.spring.user.application.usecases.accounttoken.impl;

import com.joel.spring.user.application.usecases.accounttoken.AccountTokenVerificationUseCase;
import com.joel.spring.user.domain.AccountToken;
import org.springframework.stereotype.Component;


@Component
public class AccountTokenVerificationUseCaseImpl implements AccountTokenVerificationUseCase {

    @Override
    public void isValid(AccountToken accountToken) {
        if(!accountToken.isValid()) {
            throw new RuntimeException("TODO CUSTOM EX");
        }
    }

    @Override
    public void isExpired(AccountToken accountToken) {
    //TODO VERIFY date
    }
}
