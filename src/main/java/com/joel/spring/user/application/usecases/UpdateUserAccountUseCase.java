package com.joel.spring.user.application.usecases;

import com.joel.spring.user.domain.User;

public interface UpdateUserAccountUseCase {
    User update(User user);
}
