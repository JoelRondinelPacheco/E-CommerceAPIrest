package com.joel.spring.user.domain;

import com.joel.spring.user.util.AccountTokenType;

import java.util.Date;

public class AccountToken {
    private String id;
    private String token;
    private AccountTokenType tokenType;
    private boolean valid;
    private Date expires;
}
