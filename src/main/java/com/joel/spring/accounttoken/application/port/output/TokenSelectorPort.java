package com.joel.spring.accounttoken.application.port.output;

import com.joel.spring.user.domain.AccountToken;

public interface TokenSelectorPort <T>{
    AccountToken get(T t);
}
