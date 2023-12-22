package com.joel.spring.services;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;

public interface IUserService extends ICrudService<UserEntity, UserPostReqDTO, UserEditReqDTO, String> {
    public UserEntity save(UserPostReqDTO dto);
    public UserEntity findByEmail(String email) throws NotFoundException;
    boolean existsByEmail(String email);
    boolean existsById(String id);
}
