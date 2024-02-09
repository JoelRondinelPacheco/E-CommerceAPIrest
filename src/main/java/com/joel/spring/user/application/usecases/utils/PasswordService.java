package com.joel.spring.user.application.usecases.utils;

import com.joel.spring.user.dto.LoginPasswordsDTO;
import com.joel.spring.user.dto.PasswordsDTO;

public interface PasswordService {
    void equalsOrThrows(PasswordsDTO passwords);
    String encrypt (String password);

    void checkLoginPasswordsOrThrows(LoginPasswordsDTO passwords);
}
