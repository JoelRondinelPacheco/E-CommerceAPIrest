package com.joel.spring.user.adapter.output.persistence.utils;

import com.joel.spring.user.application.port.output.EmailVerificationPort;
import com.joel.spring.user.adapter.output.persistence.UtilsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailVerificationAdapter implements EmailVerificationPort {

    @Autowired
    private UtilsUserRepository userRepository;

    @Override
    public boolean exists(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
