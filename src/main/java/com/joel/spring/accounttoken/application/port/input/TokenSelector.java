package com.joel.spring.accounttoken.application.port.input;

import com.joel.spring.accounttoken.domain.AccountToken;

public interface TokenSelector {
    AccountToken getById(String id);
    AccountToken getByToken(String token);
    AccountToken getByUserEmail(String userEmail);
}
