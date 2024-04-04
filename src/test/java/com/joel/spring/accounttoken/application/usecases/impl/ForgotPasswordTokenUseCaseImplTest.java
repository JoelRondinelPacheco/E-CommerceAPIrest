package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.usecases.ForgotPasswordTokenUseCase;
import com.joel.spring.accounttoken.domain.AccountToken;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ForgotPasswordTokenUseCaseImplTest {

    @Test
    void testUpdateToken() {
        AccountToken accountToken = new AccountToken();

        ForgotPasswordTokenUseCase forgotPasswordTokenUseCase = new ForgotPasswordTokenUseCaseImpl();

        AccountToken actualAccountToken = forgotPasswordTokenUseCase.updateToken(accountToken);

        assertTrue(actualAccountToken.isValid());
        assertTrue(actualAccountToken.getExpires().isAfter(LocalDate.now()));
    }

}