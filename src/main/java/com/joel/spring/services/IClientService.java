package com.joel.spring.services;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.entities.UserEntity;

public interface IClientService extends ICrudService<UserEntity, UserPostReqDTO, UserEditReqDTO, Long> {
}
