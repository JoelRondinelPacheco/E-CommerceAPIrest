package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.usecases.NewAccountTokenUseCase;
import com.joel.spring.accounttoken.domain.AccountToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewAccountTokenUseCaseImplTest {


    @Test
    void testCreateAccountToken() {
        NewAccountTokenUseCase accountTokenUseCase = new NewAccountTokenUseCaseImpl();

        AccountToken expectedAccountToken = AccountToken.NewUserAccountToken("Generate-random-token-or-jwt");
        AccountToken actualAccountToken = accountTokenUseCase.create();
        String expectedToken = "Generate-random-token-or-jwt";

        assertEquals(expectedAccountToken.getToken(), actualAccountToken.getToken());
        assertEquals(expectedAccountToken.getTokenType(), actualAccountToken.getTokenType());
        assertEquals(expectedAccountToken.isValid(), actualAccountToken.isValid());
        assertEquals(expectedToken, actualAccountToken.getToken());
    }


}