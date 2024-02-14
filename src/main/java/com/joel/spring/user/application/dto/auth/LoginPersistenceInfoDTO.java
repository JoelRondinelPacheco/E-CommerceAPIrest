package com.joel.spring.user.application.dto.auth;

import lombok.Data;

@Data
public class LoginPersistenceInfoDTO {
    private String id;
    private String password;
}
