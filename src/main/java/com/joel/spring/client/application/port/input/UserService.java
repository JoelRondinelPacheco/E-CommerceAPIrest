package com.joel.spring.client.application.port.input;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.client.infrastructure.output.persistence.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.CrudService;

import java.util.List;

public interface UserService {
    boolean existsById(String id);
    UserPersonalInfoDTO getUserPersonalInfo(String id) throws NotFoundException;
    List<UserPersonalInfoDTO> getAllDTO();
    UserPersonalInfoDTO updateDTO(UserEditReqDTO body) throws NotFoundException;

    String delete(String useId);
}
