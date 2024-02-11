package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.usecases.ResetPasswordUserCase;
import com.joel.spring.user.domain.AccountToken;

public class ResetPasswordUserCaseImpl implements ResetPasswordUserCase {
    @Override
    public AccountToken resetPasswordFor(String userEmail) {
        return null;
    }
}
