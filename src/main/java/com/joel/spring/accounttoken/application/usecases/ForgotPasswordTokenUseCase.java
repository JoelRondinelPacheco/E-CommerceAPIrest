package com.joel.spring.accounttoken.application.usecases;

import com.joel.spring.accounttoken.domain.AccountToken;

public interface ForgotPasswordTokenUseCase {
    AccountToken updateToken(AccountToken accountToken);
}
