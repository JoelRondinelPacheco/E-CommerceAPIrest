package com.joel.spring.dtos.users;

import lombok.Getter;

@Getter
public class UserEditReqDTO extends UserPostReqDTO {
    private Long client_id;
}
