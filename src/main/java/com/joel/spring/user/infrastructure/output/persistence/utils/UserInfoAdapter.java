package com.joel.spring.user.infrastructure.output.persistence.utils;

import com.joel.spring.user.application.dto.auth.LoginPersistenceInfoDTO;
import com.joel.spring.user.application.port.output.UserDTOSelectorPort;
import com.joel.spring.user.domain.User;
import com.joel.spring.user.application.dto.UserPersonalInfoDTO;
import com.joel.spring.user.infrastructure.output.persistence.UserJpaMySQLRepository;
import com.joel.spring.user.infrastructure.output.persistence.UserEntity;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

public class UserInfoAdapter implements UserDTOSelectorPort {

    @Autowired
    private UserJpaMySQLRepository userRepository;
    @Autowired
    @Qualifier("userMapper")
    private Mapper<UserEntity, User> mapper;

    public User get(String email) {
        Optional<UserEntity> userEntity = this.userRepository.findByEmail(email);
        if (userEntity.isPresent()) {
            return this.mapper.entityToDomain(userEntity.get());
        }
        //TODO
        throw new RuntimeException("TODO CUSTOM EX");
    }

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
        return null;
    }
}
