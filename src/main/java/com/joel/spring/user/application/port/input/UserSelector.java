package com.joel.spring.user.application.port.input;

import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import com.joel.spring.user.domain.User;

import java.util.List;

public interface UserSelector <T>{
    User get(T param);
}
