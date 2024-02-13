package com.joel.spring.user.application.port.input;

import com.joel.spring.user.domain.User;

public interface UserSelector <T>{
    User get(T param);
}
