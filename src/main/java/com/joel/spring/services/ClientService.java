package com.joel.spring.services;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService implements IClientService {

    @Autowired
    private IUserRepository clientRepository;

    @Override
    public UserEntity getById(Long id) throws NotFoundException {
        Optional<UserEntity> optionalClient =  this.clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            UserEntity userEntity = optionalClient.get();
            return userEntity;
        }
        throw new NotFoundException("UserEntity not found");
    }

    @Override
    @Transactional
    public UserEntity save(UserPostReqDTO dto) {
        return this.clientRepository.save(new UserEntity(dto.getName(), dto.getLastname(), dto.getDni()));

    }

    @Override
    public String delete(Long id) {
        this.clientRepository.deleteById(id);
        return "UserEntity deleted";
    }

    @Override
    public UserEntity update(UserEditReqDTO dto) throws NotFoundException {
        UserEntity userEntity = this.getById(dto.getClient_id());
        userEntity.setName(dto.getName());
        userEntity.setLastname(dto.getLastname());
        userEntity.setDni(dto.getDni());
        this.clientRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> getAll() {
        return this.clientRepository.findAll();
    }
}
