package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.port.output.NewAccountTokenPort;
import com.joel.spring.user.application.usecases.NewAccountTokenUserCase;
import com.joel.spring.user.domain.AccountToken;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("newAccount")
public class NewAccountTokenUserCaseImpl implements NewAccountTokenUserCase {

    @Autowired
    private NewAccountTokenPort accountTokenPort;

    @Override
    public AccountToken create() {
        String token = "Generate-random-token-or-jwt";
        AccountToken accountToken = AccountToken.NewUserAccountToken(token);
        return this.accountTokenPort.save(accountToken);
    }

}
