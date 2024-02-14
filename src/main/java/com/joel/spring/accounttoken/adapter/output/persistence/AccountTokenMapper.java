package com.joel.spring.accounttoken.adapter.output.persistence;

import com.joel.spring.user.domain.AccountToken;

public class AccountTokenMapper {

    public AccountTokenEntity domainToEntity(AccountToken accountToken) {
        return new AccountTokenEntity();
    }

    public AccountToken entityToDomain(AccountTokenEntity accountTokenEntity) {
        return new AccountToken();
    }
}
