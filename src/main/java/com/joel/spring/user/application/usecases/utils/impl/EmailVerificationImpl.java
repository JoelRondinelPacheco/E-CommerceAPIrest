package com.joel.spring.user.application.usecases.utils.impl;

import com.joel.spring.user.application.port.output.EmailVerificationPort;
import com.joel.spring.user.application.usecases.utils.EmailVerification;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailVerificationImpl implements EmailVerification {

    @Autowired
    private EmailVerificationPort verifyEmail;

    @Override
    public boolean exists(String email) {
        return this.verifyEmail.exists(email);
    }
}
