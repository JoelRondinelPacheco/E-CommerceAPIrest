package com.joel.spring.user.application.port.output;

import com.joel.spring.user.domain.User;

public interface AuthRepositoryPort {
    User register(User user);
    User registrationUpdate(User user);

}
