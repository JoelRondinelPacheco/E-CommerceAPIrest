package com.joel.spring.accounttoken.application.port.output;

import com.joel.spring.user.domain.User;

public interface AuthRepositoryPort {
    User register(User user);
    User update(User user);

}
