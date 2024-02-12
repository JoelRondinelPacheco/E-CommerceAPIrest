package com.joel.spring.user.application.usecases.accounttoken;

import com.joel.spring.user.domain.AccountToken;

public interface AccountTokenVerificationUseCase {
    void isValid(AccountToken accountToken);
    void isExpired(AccountToken accountToken);
}
