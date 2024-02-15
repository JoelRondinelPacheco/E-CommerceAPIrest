package com.joel.spring.accounttoken.application.port.output;

import com.joel.spring.accounttoken.domain.AccountToken;

public interface TokenSelectorPort {
    AccountToken getById(String id);
    AccountToken getByToken(String token);
    AccountToken getByUserEmail(String userEmail);
}
