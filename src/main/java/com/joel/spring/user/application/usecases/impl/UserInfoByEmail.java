package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import com.joel.spring.user.application.port.input.UserSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("userByEmail")
public class UserInfoByEmail implements UserSelector<String> {

    @Override
    public UserPersonalInfoDTO get(String user) {
        return null;
    }
}
