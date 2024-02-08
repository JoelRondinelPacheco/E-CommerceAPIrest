package com.joel.spring.user.application.usecases;

import com.joel.spring.user.application.port.input.AccountService;
import com.joel.spring.user.dto.ResetPasswordDTO;

public class AccountServiceImpl implements AccountService {
    @Override
    public String validate(String token) {
        return null;
    }

    @Override
    public String forgotPassword(String email) {
        return null;
    }

    @Override
    public String resetPassword(ResetPasswordDTO newPassword) {
        return null;
    }
}
