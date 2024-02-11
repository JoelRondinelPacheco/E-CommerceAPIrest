package com.joel.spring.user.application.usecases;

import com.joel.spring.user.domain.AccountToken;

public interface ResetPasswordUserCase {
    AccountToken resetPasswordFor(String userEmail);
}
