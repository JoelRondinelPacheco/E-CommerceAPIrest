package com.joel.spring.dtos.users;

import lombok.Getter;

@Getter
public class UserPostReqDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
