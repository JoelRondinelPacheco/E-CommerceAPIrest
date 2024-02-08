package com.joel.spring.user.dto;

public class ResetPasswordDTO {
    private String password;
    private String repeatedPassword;

    public ResetPasswordDTO() {
    }

    public ResetPasswordDTO(String password, String repeatedPassword) {
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }
}
