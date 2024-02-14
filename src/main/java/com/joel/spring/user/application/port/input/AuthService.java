package com.joel.spring.user.application.port.input;

import com.joel.spring.user.application.dto.auth.UserCredentialsDTO;
import com.joel.spring.user.application.dto.auth.RegisterUserDTO;

public interface AuthService {

    String register(RegisterUserDTO user);

    String login(UserCredentialsDTO userCredentials);
}
