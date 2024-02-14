package com.joel.spring.user.application.port.output;

import com.joel.spring.user.dto.UserPersonalInfoDTO;

import java.util.Optional;

public interface UserDTOSelectorPort {
    UserPersonalInfoDTO byId(String id);
    UserPersonalInfoDTO byEmail(String email);
}
