package com.joel.spring.user.application.port.output;

public interface EmailVerificationPort {
    boolean exists(String email);
}
