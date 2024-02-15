package com.joel.spring.accounttoken.adapter.output.persistence;

import com.joel.spring.accounttoken.domain.AccountToken;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("accountTokenMapper")
public class AccountTokenMapper implements Mapper<AccountTokenEntity, AccountToken> {

    public AccountTokenEntity domainToEntity(AccountToken accountToken) {
        return new AccountTokenEntity();
    }

    public AccountToken entityToDomain(AccountTokenEntity accountTokenEntity) {
        return new AccountToken();
    }
}
