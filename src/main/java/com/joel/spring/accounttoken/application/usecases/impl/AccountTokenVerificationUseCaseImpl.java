package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.usecases.AccountTokenVerificationUseCase;
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
