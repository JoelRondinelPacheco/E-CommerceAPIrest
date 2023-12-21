package com.joel.spring.controllers;

import com.joel.spring.config.ValidationsConfig;
import com.joel.spring.dtos.users.*;
import com.joel.spring.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private IAuthService authService;
    @Autowired private ValidationsConfig validations;

    @PostMapping("/register")
    private ResponseEntity<AuthResDTO> register(@RequestBody UserPostReqDTO body) {
        AuthResDTO res = new AuthResDTO();
        List<InvalidFieldDTO> errors = this.validations.userValidation().registerValidation(body);
        if (!errors.isEmpty()) {
            res.setResponse("Invalid fields");
            res.setErrors(errors);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        AuthInfoDTO info = this.authService.register(body);
        res.setResponse(info.getResponse());
        res.setErrors(info.getErrors());
        return new ResponseEntity<>(res, info.getHttpStatusCode());
    }

    @PostMapping("/login")
    private ResponseEntity<AuthResDTO> login(@RequestBody LoginDTO body) {
        AuthResDTO res = new AuthResDTO();
        List<InvalidFieldDTO> errorFields = this.validations.userValidation().loginValidation(body);

        if (!errorFields.isEmpty()) {
            res.setResponse("Invalid fields");
            res.setErrors(errorFields);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        AuthInfoDTO info = this.authService.login(body);
        res.setResponse(info.getResponse());
        res.setErrors(info.getErrors());
        return new ResponseEntity<>(res, info.getHttpStatusCode());
    }
}
