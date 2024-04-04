package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.usecases.AccountTokenVerificationUseCase;
import com.joel.spring.accounttoken.domain.AccountToken;
import com.joel.spring.user.util.AccountTokenType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;


@Component
public class AccountTokenVerificationUseCaseImpl implements AccountTokenVerificationUseCase {

    @Override
    public void verifyToken(AccountToken accountToken) {
        this.isValid(accountToken);
        this.isExpired(accountToken);
    }

    @Override
    public void isValid(AccountToken accountToken) {
        if(!accountToken.isValid()) {
            throw new RuntimeException("TODO CUSTOM EX");
        }
    }

    @Override
    public void isExpired(AccountToken accountToken) {
    if (accountToken.getTokenType().equals(AccountTokenType.RESET_PASSWORD)) {
        if (accountToken.getExpires().isBefore(LocalDate.now())) {
            throw new RuntimeException("Token expired");
        }
    }
    }

    @Override
    public void isValidationAccountToken(AccountToken accountToken) {

    }

    @Override
    public void isResetPasswordToken(AccountToken accountToken) {

    }
}
