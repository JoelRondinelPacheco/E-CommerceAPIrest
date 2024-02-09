package com.joel.spring.user.application.usecases.utils;

public interface EmailVerification {
    boolean exists(String email);
}
