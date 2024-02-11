package com.joel.spring.user.application.port.output;

import com.joel.spring.user.domain.AccountToken;

public interface AccountTokenRepository {
    AccountToken getBy(String token);

}
