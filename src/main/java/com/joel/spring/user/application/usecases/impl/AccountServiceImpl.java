package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.port.input.AccountService;
import com.joel.spring.user.application.port.output.AccountTokenRepository;
import com.joel.spring.user.dto.PasswordsDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountTokenRepository accountTokenRepository;
    /*
    TODO
        Create account token whit jwt
     */
    @Override
    public String validate(String token) {
       //buscar token en db

        //activar cuenta
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
