package com.joel.spring.user.application.dto.auth;

public class ResetPasswordDTO extends PasswordsDTO {
    private String token;

    public ResetPasswordDTO(String token) {
        this.token = token;
    }

    public ResetPasswordDTO(String password, String repeatedPassword, String token) {
        super(password, repeatedPassword);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
