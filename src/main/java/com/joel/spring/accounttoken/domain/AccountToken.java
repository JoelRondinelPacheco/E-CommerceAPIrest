package com.joel.spring.accounttoken.domain;

import com.joel.spring.user.util.AccountTokenType;

import java.time.LocalDate;

public class AccountToken {
    private String id;
    private String token;
    private AccountTokenType tokenType;
    private boolean valid;
    private LocalDate expires;

    public AccountToken(){

    }
    private AccountToken(String token) {
        this.token = token;
        this.tokenType = AccountTokenType.VALIDATE_ACCOUNT;
        this.valid = true;
    }
    public static AccountToken NewUserAccountToken (String token) {
        return new AccountToken(token);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AccountTokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(AccountTokenType tokenType) {
        this.tokenType = tokenType;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public void setExpires(LocalDate expires) {
        this.expires = expires;
    }
}
