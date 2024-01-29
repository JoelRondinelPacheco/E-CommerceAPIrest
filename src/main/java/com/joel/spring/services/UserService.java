package com.joel.spring.services;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface UserService extends CrudService<UserEntity, UserPostReqDTO, UserEditReqDTO, String> {
    UserEntity save(UserPostReqDTO dto);
    UserEntity findByEmail(String email) throws NotFoundException;
    boolean existsByEmail(String email);
    boolean existsById(String id);
    UserPersonalInfoDTO getUserPersonalInfo(String id) throws NotFoundException;
    List<UserPersonalInfoDTO> getAllDTO();
    UserPersonalInfoDTO updateDTO(UserEditReqDTO body) throws NotFoundException;
}
