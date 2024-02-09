package com.joel.spring.user.application.usecases.utils;

public interface PasswordService {
    void equalsOrThrows(String password, String repeatedPassword);

    String encrypt (String password);
}
