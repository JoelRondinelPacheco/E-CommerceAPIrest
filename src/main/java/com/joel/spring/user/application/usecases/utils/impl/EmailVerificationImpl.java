package com.joel.spring.user.application.usecases.utils.impl;

import com.joel.spring.user.application.port.output.EmailVerificationPort;
import com.joel.spring.user.application.usecases.utils.EmailVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailVerificationImpl implements EmailVerification {

    @Autowired
    private EmailVerificationPort verifyEmail;

    @Override
    public void existsOrThrows(String email) {
        if (this.verifyEmail.exists(email)) {
            throw new RuntimeException("TODO CUSTOM EX");
        };
    }

    @Override
    public void isValidORThrows(String email) {

    }
}
