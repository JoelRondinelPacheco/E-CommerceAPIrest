package com.joel.spring.controllers;

import com.joel.spring.config.ValidationsConfig;
import com.joel.spring.dtos.users.*;
import com.joel.spring.services.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

import java.util.List;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authorization/Authentication", description = "Operations pertaining to products in the Product Management System")
public class AuthController {

    @Autowired private IAuthService authService;
    @Autowired private ValidationsConfig validations;

    @Operation(summary = "Register", description = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request. Campos invalidos para el registro" ),
            @ApiResponse(responseCode = "409", description = "Conflict. Ya existe un usuario registrado con ese email"),
            @ApiResponse(responseCode = "201", description = "Created. Usuario registrado")}
    )
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

    @Valid
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
