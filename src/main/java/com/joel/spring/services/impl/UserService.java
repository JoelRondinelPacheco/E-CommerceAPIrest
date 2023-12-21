package com.joel.spring.services.impl;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.IUserRepository;
import com.joel.spring.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserEntity getById(Long id) throws NotFoundException {
        Optional<UserEntity> optionalClient =  this.userRepository.findById(id);
        if (optionalClient.isPresent()) {
            UserEntity userEntity = optionalClient.get();
            return userEntity;
        }
        throw new NotFoundException("UserEntity not found");
    }

    @Override
    @Transactional
    public UserEntity save(UserPostReqDTO dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String passwordEncrypted = encoder.encode(dto.getPassword());
        return this.userRepository.save(new UserEntity(dto.getFirstName(), dto.getLastName(), dto.getEmail(),passwordEncrypted));
    }

    @Override
    public String delete(Long id) {
        this.userRepository.deleteById(id);
        return "UserEntity deleted";
    }

    @Override
    public UserEntity update(UserEditReqDTO dto) throws NotFoundException {
        UserEntity userEntity = this.getById(dto.getClient_id());
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        return this.userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public UserEntity findByEmail(String email) throws NotFoundException {
        Optional<UserEntity> user = this.userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        throw new NotFoundException("User not found");
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
