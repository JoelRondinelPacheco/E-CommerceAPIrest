package com.joel.spring.user.application.usecases;

import com.joel.spring.user.domain.AccountToken;
import com.joel.spring.user.domain.User;

public interface NewAccountTokenUserCase {
    AccountToken createFor(User user);
}
