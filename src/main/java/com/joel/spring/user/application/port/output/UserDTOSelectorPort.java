package com.joel.spring.user.application.port.output;

import com.joel.spring.user.application.dto.UserPersonalInfoDTO;
import com.joel.spring.user.application.dto.auth.LoginPersistenceInfoDTO;

public interface UserDTOSelectorPort {
    UserPersonalInfoDTO byId(String id);
    UserPersonalInfoDTO byEmail(String email);
    LoginPersistenceInfoDTO loginInfo(String email);
}
