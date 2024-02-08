package com.joel.spring.user.application.port.input;

import com.joel.spring.user.dto.UserCredentialsDTO;
import com.joel.spring.user.dto.RegisterUserDTO;

public interface AuthService {

    String register(RegisterUserDTO user);

    String login(UserCredentialsDTO userCredentials);
}
