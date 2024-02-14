package com.joel.spring.user.application.dto.auth;

public class PasswordsDTO {
    private String password;
    private String repeatedPassword;

    public PasswordsDTO() {
    }

    public PasswordsDTO(String password, String repeatedPassword) {
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }
}
