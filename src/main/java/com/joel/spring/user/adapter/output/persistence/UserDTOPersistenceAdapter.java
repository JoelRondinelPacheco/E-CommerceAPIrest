package com.joel.spring.user.adapter.output.persistence;

import com.joel.spring.user.application.dto.UserPersonalInfoDTO;
import com.joel.spring.user.application.dto.auth.LoginPersistenceInfoDTO;
import com.joel.spring.user.application.port.output.UserDTOSelectorPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDTOPersistenceAdapter implements UserDTOSelectorPort {

    @Autowired
    private UserDTOsJpaMySQLRepository userRepository;


    @Override
    public UserPersonalInfoDTO byId(String id) {
        return null;
    }

    @Override
    public UserPersonalInfoDTO byEmail(String email){
        Optional<UserPersonalInfoDTO> optional = this.userRepository.findByEmail(email);
        if (optional.isPresent()) {
            return optional.get();
        }
        //TODO
        throw new RuntimeException("TODO CUSTOM EX");
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
