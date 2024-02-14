package com.joel.spring.user.infrastructure.input.web;

import com.joel.spring.user.application.port.input.AccountService;
import com.joel.spring.user.dto.ResetPasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        return new ResponseEntity<>(this.accountService.forgotPassword(email), HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDTO body) {
        return new ResponseEntity<>(this.accountService.resetPassword(body), HttpStatus.OK);
    }


}
