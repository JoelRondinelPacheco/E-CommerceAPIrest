package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.usecases.NewAccountTokenUserCase;
import com.joel.spring.user.domain.AccountToken;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("newAccount")
public class NewAccountTokenUserCaseImpl implements NewAccountTokenUserCase {

    @Override
    public AccountToken createFor(User user) {
        String token = "Generate-random-token-or-jwt";
        return AccountToken.NewUserAccountToken(token);
    }

}
