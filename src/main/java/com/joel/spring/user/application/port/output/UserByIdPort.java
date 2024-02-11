package com.joel.spring.user.application.port.output;

import com.joel.spring.user.domain.User;

public interface UserByIdPort {
    public User get(String id);
}
