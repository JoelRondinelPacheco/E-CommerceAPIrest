package com.joel.spring.accounttoken.application.usecases.impl;

import com.joel.spring.accounttoken.application.usecases.AccountTokenVerificationUseCase;
import com.joel.spring.accounttoken.domain.AccountToken;
import com.joel.spring.user.util.AccountTokenType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccountTokenVerificationUseCaseImplTest {

    //todo before all, before each etc

    @Test
    void testIsExpiredNewAccountToken() {
        AccountTokenVerificationUseCase accountTokenVerificationUseCase = new AccountTokenVerificationUseCaseImpl();
        AccountToken accountToken = AccountToken.NewUserAccountToken("token");

        accountTokenVerificationUseCase.verifyToken(accountToken);
    }

    @Test
    void testIsExpiredValidResetPasswordAccountToken() {
        LocalDate date = LocalDate.now().plusDays(3);
        AccountTokenVerificationUseCase accountTokenVerificationUseCase = new AccountTokenVerificationUseCaseImpl();
        AccountToken accountToken = AccountToken.NewUserAccountToken("token");
        accountToken.setTokenType(AccountTokenType.RESET_PASSWORD);
        accountToken.setValid(true);
        accountToken.setExpires(date);

        accountTokenVerificationUseCase.verifyToken(accountToken);
    }

    @Test
    void testIsExpiredInvalidResetPasswordAccountToken() {
        LocalDate date = LocalDate.now().minusDays(3);
        AccountTokenVerificationUseCase accountTokenVerificationUseCase = new AccountTokenVerificationUseCaseImpl();
        AccountToken accountToken = AccountToken.NewUserAccountToken("token");
        accountToken.setTokenType(AccountTokenType.RESET_PASSWORD);
        accountToken.setValid(true);
        accountToken.setExpires(date);

        assertThrows(RuntimeException.class, () -> {
            accountTokenVerificationUseCase.isExpired(accountToken);
        });
    }

    @Test
    void testIsExpiredInvalidResetPasswordAccountToken2() {
        LocalDate date = LocalDate.now().minusDays(3);
        AccountTokenVerificationUseCase accountTokenVerificationUseCase = new AccountTokenVerificationUseCaseImpl();
        AccountToken accountToken = AccountToken.NewUserAccountToken("token");
        accountToken.setTokenType(AccountTokenType.RESET_PASSWORD);
        accountToken.setValid(false);
        accountToken.setExpires(date);

        assertThrows(RuntimeException.class, () -> {
            accountTokenVerificationUseCase.isExpired(accountToken);
        });
    }

    @Test
    void testVerifyToken() {
        AccountToken accountToken = AccountToken.NewUserAccountToken("token");
        AccountTokenVerificationUseCase accountTokenVerificationUseCase = new AccountTokenVerificationUseCaseImpl();

        accountTokenVerificationUseCase.verifyToken(accountToken);
    }

}