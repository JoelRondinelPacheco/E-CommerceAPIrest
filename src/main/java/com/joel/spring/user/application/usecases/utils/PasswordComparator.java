package com.joel.spring.user.application.usecases.utils;

public interface PasswordComparator {
    void equalsOrThrows(String password, String repeatedPassword);
}
