package com.joel.spring.user.application.usecases.utils.impl;

import com.joel.spring.user.application.usecases.utils.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void equalsOrThrows(String password, String repeatedPassword) {
        if (!password.equals(repeatedPassword)) {
            throw new RuntimeException("TODO CUSTOM EX");
        };
    }

    @Override
    public String encrypt(String password) {
        return this.passwordEncoder.encode(password);
    }
}
