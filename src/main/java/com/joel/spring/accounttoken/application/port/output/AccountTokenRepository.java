package com.joel.spring.accounttoken.application.port.output;

import com.joel.spring.accounttoken.domain.AccountToken;

public interface AccountTokenRepository {
    AccountToken getBy(String token);

}
