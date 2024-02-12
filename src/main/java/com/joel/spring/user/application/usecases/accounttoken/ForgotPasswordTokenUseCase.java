package com.joel.spring.user.application.usecases.accounttoken;

import com.joel.spring.user.domain.AccountToken;

public interface ForgotPasswordTokenUseCase {
    AccountToken updateToken(AccountToken accountToken);
}
