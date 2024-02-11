package com.joel.spring.user.infrastructure.input.web;

import com.joel.spring.user.application.port.input.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/validate/{token}")
    public ResponseEntity<?> validate(@PathVariable(name = "token") String token) {
        this.accountService.validate(token);
        return null;
    }

}
