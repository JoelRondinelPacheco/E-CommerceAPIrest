package com.joel.spring.user.application.dto;

import lombok.Getter;

@Getter
public class UserEditReqDTO extends UserPostReqDTO {
    private String userId;
}
