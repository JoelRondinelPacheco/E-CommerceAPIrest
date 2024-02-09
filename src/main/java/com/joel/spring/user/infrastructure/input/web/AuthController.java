package com.joel.spring.user.infrastructure.input.web;

import com.joel.spring.user.application.port.input.AuthService;
import com.joel.spring.user.dto.UserCredentialsDTO;
import com.joel.spring.user.dto.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    //TODO array de respuestas al no validar elbody

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDTO newUser) {
        //TODO VALIDATE DTO HERE
        return null;
    }

    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody UserCredentialsDTO userCredentials) {

        //TODO VALIDATE DTO HERE
        return null;
    }
}