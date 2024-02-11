package com.joel.spring.user.domain;

import com.joel.spring.user.util.AccountTokenType;
import lombok.Data;

import java.util.Date;

public class AccountToken {
    private String id;
    private String token;
    private AccountTokenType tokenType;
    private boolean valid;
    private Date expires;
    private User user;

    //Creacion de token en dominio???

    private AccountToken(String token) {
        this.token = token;
        this.tokenType = AccountTokenType.VALIDATE_ACCOUNT;
        this.valid = true;

    }
    public static AccountToken NewUserAccountToken (String token) {
        return new AccountToken(token);
    }


}
