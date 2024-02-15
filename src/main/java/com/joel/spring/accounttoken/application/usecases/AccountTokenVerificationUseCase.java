package com.joel.spring.accounttoken.application.usecases;

import com.joel.spring.accounttoken.domain.AccountToken;

public interface AccountTokenVerificationUseCase {

    void verifyToken(AccountToken accountToken);
    void isValid(AccountToken accountToken);
    void isExpired(AccountToken accountToken);

    void isValidationAccountToken(AccountToken accountToken);
    void isResetPasswordToken(AccountToken accountToken);
}
