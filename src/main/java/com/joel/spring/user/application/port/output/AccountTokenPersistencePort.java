package com.joel.spring.user.application.port.output;

import com.joel.spring.accounttoken.domain.AccountToken;

public interface AccountTokenPersistencePort {
    AccountToken save(AccountToken accountToken);
}
