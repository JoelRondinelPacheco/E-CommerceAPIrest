package com.joel.spring.controllers;

import com.joel.spring.config.ValidationsConfig;
import com.joel.spring.dtos.users.AuthResDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.user.dto.UserCredentialsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

   // @Autowired private AuthService authService;
    @Autowired private ValidationsConfig validations;

    @PostMapping("/register")
    private ResponseEntity<List<AuthResDTO>> register(@RequestBody UserPostReqDTO body) {/*
        List<AuthResDTO> res = new ArrayList<>();
        List<AuthResDTO> errors = this.validations.userValidation().registerValidation(body);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        AuthInfoDTO info = this.authService.register(body);
        if (info.getErrors().isEmpty()) {
            res.add(new AuthResDTO("Ok", info.getResponse()));
        } else {
            res = info.getErrors();
        }
        return new ResponseEntity<>(res, info.getHttpStatusCode());*/
        return null;
    }

    @PostMapping("/login")
    private ResponseEntity<List<AuthResDTO>> login(@RequestBody UserCredentialsDTO body) {
       /* List<AuthResDTO> res = new ArrayList<>();
        List<AuthResDTO> errorFields = this.validations.userValidation().loginValidation(body);

        if (!errorFields.isEmpty()) {
            return new ResponseEntity<>(errorFields, HttpStatus.BAD_REQUEST);
        }
        AuthInfoDTO info = this.authService.login(body);
        if (info.getErrors().isEmpty()) {
            res.add(new AuthResDTO("token", info.getResponse()));
        } else {
            res = info.getErrors();
        }
        return new ResponseEntity<>(res, info.getHttpStatusCode());*/
        return null;
    }
}
