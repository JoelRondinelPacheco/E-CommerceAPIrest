package com.joel.spring.user.application.port.input;

import com.joel.spring.dtos.users.UserPersonalInfoDTO;

import java.util.List;

public interface UserSelector <T>{
    UserPersonalInfoDTO get(T param);
}
