package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.port.input.AccountService;
import com.joel.spring.user.dto.PasswordsDTO;

public class AccountServiceImpl implements AccountService {

    /*
    TODO
        Create account token whit jwt
     */
    @Override
    public String validate(String token) {
        /*
        TODO
            get account
            verify token
            activate account
         */
        return null;
    }

    @Override
    public String forgotPassword(String email) {
        /*
        TODO
            get account
            set accountToken
            send email
         */
        return null;
    }

    @Override
    public String resetPassword(PasswordsDTO newPassword) {
        /*
        TODO
            get account
            verify token
            reassign password
         */
        return null;
    }
}
