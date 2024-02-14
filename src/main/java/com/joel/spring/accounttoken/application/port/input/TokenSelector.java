package com.joel.spring.accounttoken.application.port.input;

import com.joel.spring.user.domain.AccountToken;

public interface TokenSelector <T> {
    AccountToken get(T t);
}
