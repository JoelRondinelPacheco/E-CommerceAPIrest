package com.joel.spring.user.infrastructure.output.persistence.utils;

import com.joel.spring.user.application.port.output.EmailVerificationPort;
import com.joel.spring.user.infrastructure.output.persistence.UtilsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailVerificationAdapter implements EmailVerificationPort {

    @Autowired
    private UtilsUserRepository userRepository;

    @Override
    public boolean exists(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
