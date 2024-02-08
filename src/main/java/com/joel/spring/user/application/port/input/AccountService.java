package com.joel.spring.user.application.port.input;

import com.joel.spring.user.dto.ResetPasswordDTO;

public interface AccountService {

    String validate(String token);
    String forgotPassword(String email);
    String resetPassword(ResetPasswordDTO newPassword);
}
