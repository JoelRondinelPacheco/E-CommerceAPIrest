package com.joel.spring.accounttoken.application.port.output;

import com.joel.spring.user.domain.AccountToken;

public interface AccountTokenRepository {
    AccountToken getBy(String token);

}
