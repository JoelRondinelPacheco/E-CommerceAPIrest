package com.joel.spring.accounttoken.application.usecases;

import com.joel.spring.user.domain.AccountToken;

public interface AccountTokenVerificationUseCase {
    void isValid(AccountToken accountToken);
    void isExpired(AccountToken accountToken);
}
