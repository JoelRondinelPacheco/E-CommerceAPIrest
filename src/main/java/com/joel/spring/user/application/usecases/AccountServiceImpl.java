package com.joel.spring.user.application.usecases;

import com.joel.spring.user.application.port.input.AccountService;
import com.joel.spring.user.dto.ResetPasswordDTO;

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
    public String resetPassword(ResetPasswordDTO newPassword) {
        /*
        TODO
            get account
            verify token
            reassign password
         */
        return null;
    }
}
