package com.joel.spring.controllers;

import com.joel.spring.config.ValidationsConfig;
import com.joel.spring.dtos.users.*;
import com.joel.spring.services.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    //name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String::class, example = "Bearer access_token")
    @Parameter(name = "Authorization", description = "Header for access token", example = "Bearer accessToken", required = true )
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "For Success as well as No Data found scenerio."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error") })
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
