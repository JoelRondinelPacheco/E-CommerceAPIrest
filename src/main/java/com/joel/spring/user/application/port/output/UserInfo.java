package com.joel.spring.user.application.port.output;

import com.joel.spring.dtos.users.UserPersonalInfoDTO;

import java.util.Optional;

public interface UserInfo {
    Optional<UserPersonalInfoDTO> byId(String id);
    Optional<UserPersonalInfoDTO> byEmail(String email);
}
