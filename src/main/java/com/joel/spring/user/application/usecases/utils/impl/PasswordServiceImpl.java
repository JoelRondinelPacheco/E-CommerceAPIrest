package com.joel.spring.user.application.usecases.utils.impl;

import com.joel.spring.user.application.usecases.utils.PasswordService;
import com.joel.spring.user.application.dto.auth.LoginPasswordsDTO;
import com.joel.spring.user.application.dto.auth.PasswordsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void equalsOrThrows(PasswordsDTO passwords) {
        if (!passwords.getPassword().equals(passwords.getRepeatedPassword())) {
            throw new RuntimeException("TODO CUSTOM EX");
        };
    }
    @Override
    public String encrypt(String password) {
        return this.passwordEncoder.encode(password);
    }

    @Override
    public void checkLoginPasswordsOrThrows(LoginPasswordsDTO passwords) {
        if (!this.passwordEncoder.matches(passwords.getRequestLoginPassword(), passwords.getEncryptedPassword())) {
            throw new RuntimeException("TODO CHANGE EX");
        }
    }
}
