package com.joel.spring.user.application.port.input;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface UserService {
    boolean existsById(String id);
    UserPersonalInfoDTO getUserPersonalInfo(String id) throws NotFoundException;
    List<UserPersonalInfoDTO> getAllDTO();
    UserPersonalInfoDTO updateDTO(UserEditReqDTO body) throws NotFoundException;

    String delete(String useId);
}
