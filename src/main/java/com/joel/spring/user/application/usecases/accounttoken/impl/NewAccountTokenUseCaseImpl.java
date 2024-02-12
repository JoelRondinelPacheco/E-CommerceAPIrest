package com.joel.spring.user.application.usecases.accounttoken.impl;

import com.joel.spring.user.application.port.output.AccountTokenPersistencePort;
import com.joel.spring.user.application.usecases.accounttoken.NewAccountTokenUseCase;
import com.joel.spring.user.domain.AccountToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("newAccount")
public class NewAccountTokenUseCaseImpl implements NewAccountTokenUseCase {

    @Autowired
    private AccountTokenPersistencePort accountTokenPersistencePort;

    @Override
    public AccountToken create() {
        //TODO ENCRYPTAR EMAIL EN EL TOKEN
        String token = "Generate-random-token-or-jwt";
        AccountToken accountToken = AccountToken.NewUserAccountToken(token);
        return this.accountTokenPersistencePort.save(accountToken);
    }

}
