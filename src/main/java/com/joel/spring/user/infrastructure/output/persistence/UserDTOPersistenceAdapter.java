package com.joel.spring.user.infrastructure.output.persistence;

import com.joel.spring.user.application.dto.UserPersonalInfoDTO;
import com.joel.spring.user.application.dto.auth.LoginPersistenceInfoDTO;
import com.joel.spring.user.application.port.output.UserDTOSelectorPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserDTOPersistenceAdapter implements UserDTOSelectorPort {

    @Autowired
    private UserDTOsJpaMySQLRepository userRepository;

    @Override
    public UserPersonalInfoDTO byId(String id) {
        return null;
    }

    @Override
    public UserPersonalInfoDTO byEmail(String email) {
        return null;
    }

    @Override
    public LoginPersistenceInfoDTO loginInfo(String email) {
        Optional<LoginPersistenceInfoDTO> optional = this.userRepository.findLoginInfoDTO(email);
        if(optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("TODO HANDLE EX");
    }
}
