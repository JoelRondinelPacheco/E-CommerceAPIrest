package com.joel.spring.user.application.dto.auth;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String repeatedPassword;
}
