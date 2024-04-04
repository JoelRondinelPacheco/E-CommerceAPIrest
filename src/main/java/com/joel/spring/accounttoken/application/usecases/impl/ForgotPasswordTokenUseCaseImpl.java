package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.usecases.ForgotPasswordTokenUseCase;
import com.joel.spring.accounttoken.domain.AccountToken;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ForgotPasswordTokenUseCaseImpl implements ForgotPasswordTokenUseCase {
    @Override
    public AccountToken updateToken(AccountToken accountToken) {
        accountToken.setToken("FORGOT-PASSWORD-TOKEN");
        accountToken.setValid(true);
        accountToken.setExpires(LocalDate.now().plusDays(3));
        return accountToken;
    }
}
