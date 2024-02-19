package com.joel.spring.user.adapter.input.web;

import com.joel.spring.user.application.dto.auth.PasswordsDTO;
import com.joel.spring.user.application.port.input.AuthService;
import com.joel.spring.user.application.dto.auth.UserCredentialsDTO;
import com.joel.spring.user.application.dto.auth.RegisterUserDTO;
import com.joel.spring.user.application.usecases.utils.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private PasswordService passwordService;
    //TODO array de respuestas al no validar elbody

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDTO newUser) {
        this.passwordService.equalsOrThrows(new PasswordsDTO(newUser.getPassword(), newUser.getRepeatedPassword()));

        //TODO VALIDATE DTO HERE
        return new ResponseEntity<>(this.authService.register(newUser), HttpStatus.OK);
    }

    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody UserCredentialsDTO userCredentials) {

        //TODO VALIDATE DTO HERE
        return new ResponseEntity<>(this.authService.login(userCredentials), HttpStatus.OK);
    }
}