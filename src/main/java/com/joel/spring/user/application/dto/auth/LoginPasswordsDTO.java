package com.joel.spring.user.application.dto.auth;

public class LoginPasswordsDTO {
    private String requestLoginPassword;
    private String encryptedPassword;

    public LoginPasswordsDTO(String requestLoginPassword, String encryptedPassword) {
        this.requestLoginPassword = requestLoginPassword;
        this.encryptedPassword = encryptedPassword;
    }


    public String getRequestLoginPassword() {
        return requestLoginPassword;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
}
