package com.joel.spring.user.application.usecases.utils.impl;

import com.joel.spring.user.application.usecases.utils.PasswordComparator;

public class PasswordComparatorImpl implements PasswordComparator {
    @Override
    public void equalsOrThrows(String password, String repeatedPassword) {
        if (!password.equals(repeatedPassword)) {
            throw new RuntimeException("TODO CUSTOM EX");
        };
    }
}
