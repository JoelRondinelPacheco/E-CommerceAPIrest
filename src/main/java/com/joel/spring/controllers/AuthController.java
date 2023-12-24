package com.joel.spring.controllers;

import com.joel.spring.config.ValidationsConfig;
import com.joel.spring.dtos.users.*;
import com.joel.spring.services.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private IAuthService authService;
    @Autowired private ValidationsConfig validations;

    @PostMapping("/register")
    private ResponseEntity<List<AuthResDTO>> register(@RequestBody UserPostReqDTO body) {
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
        return new ResponseEntity<>(res, info.getHttpStatusCode());
    }

    @PostMapping("/login")
    private ResponseEntity<List<AuthResDTO>> login(@RequestBody LoginDTO body) {
        List<AuthResDTO> res = new ArrayList<>();
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
        return new ResponseEntity<>(res, info.getHttpStatusCode());
    }
}
