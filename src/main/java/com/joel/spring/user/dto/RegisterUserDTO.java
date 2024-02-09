package com.joel.spring.user.dto;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String repeatedPassword;
}
