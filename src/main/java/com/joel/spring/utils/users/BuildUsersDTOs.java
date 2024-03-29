package com.joel.spring.utils.users;

import com.joel.spring.user.application.dto.UserPersonalInfoDTO;
import com.joel.spring.user.adapter.output.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class BuildUsersDTOs {
    public UserPersonalInfoDTO userPersonalInfoDTO(UserEntity user) {
        return UserPersonalInfoDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
