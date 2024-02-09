package com.joel.spring.user.application.usecases.utils;

public interface EmailVerification {
    void existsOrThrows(String email);
}
