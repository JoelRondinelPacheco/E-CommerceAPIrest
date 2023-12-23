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
@Tag(name = "Authorization/Authentication", description = "Operations pertaining to login a register users")
public class AuthController {

    @Operation(summary = "Register", description = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request. Campos invalidos para el registro"),
            @ApiResponse(responseCode = "409", description = "Conflict. Ya existe un usuario registrado con ese email"),
            @ApiResponse(responseCode = "201", description = "Created. Usuario registrado")}
    )
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
    @Autowired private IAuthService authService;

    @Autowired private ValidationsConfig validations;

    @Operation(summary = "Login", description = "Authenticate user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request. Campos invalidos para el login"),
            @ApiResponse(responseCode = "401", description = "Unauthorized. Credenciales invalidas"),
            @ApiResponse(responseCode = "200", description = "OK. Usuario logeado")}
    )
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
