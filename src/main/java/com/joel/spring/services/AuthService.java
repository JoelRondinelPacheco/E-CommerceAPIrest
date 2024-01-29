package com.joel.spring.services;

import com.joel.spring.dtos.users.LoginDTO;
import com.joel.spring.dtos.users.AuthInfoDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;

public interface AuthService {
    public AuthInfoDTO login(LoginDTO login);

    public AuthInfoDTO register(UserPostReqDTO user);
}
