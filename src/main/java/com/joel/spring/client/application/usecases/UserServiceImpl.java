package com.joel.spring.client.application.usecases;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.client.infrastructure.output.persistence.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.client.infrastructure.output.persistence.JpaMySQLUserRepository;
import com.joel.spring.client.application.port.input.UserService;
import com.joel.spring.utils.CheckOptional;
import com.joel.spring.utils.users.BuildUsersDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired private JpaMySQLUserRepository jpaMySQLUserRepository;
    @Autowired private CheckOptional checkOptional;
    @Autowired private BuildUsersDTOs usersDTOs;

    @Override
    public UserEntity getById(String id) throws NotFoundException {
        Optional<UserEntity> optionalClient =  this.jpaMySQLUserRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        }
        throw new NotFoundException("UserEntity not found");
    }

    @Override
    @Transactional
    public UserEntity save(UserPostReqDTO dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String passwordEncrypted = encoder.encode(dto.getPassword());
        return this.jpaMySQLUserRepository.save(new UserEntity(dto.getFirstName(), dto.getLastName(), dto.getEmail(),passwordEncrypted));
    }

    @Override
    public String delete(String id) {
        this.jpaMySQLUserRepository.deleteById(id);
        return "UserEntity deleted";
    }

    @Override
    public UserEntity update(UserEditReqDTO dto) throws NotFoundException {
        UserEntity userEntity = this.getById(dto.getUserId());
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        return this.jpaMySQLUserRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return this.jpaMySQLUserRepository.findAll();
    }

    @Override
    public UserEntity findByEmail(String email) throws NotFoundException {
        Optional<UserEntity> user = this.jpaMySQLUserRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        throw new NotFoundException("User not found");
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.jpaMySQLUserRepository.existsByEmail(email);
    }

    @Override
    public boolean existsById(String id) {
        return this.jpaMySQLUserRepository.existsById(id);
    }

    @Override
    public UserPersonalInfoDTO getUserPersonalInfo(String id) throws NotFoundException {
        Optional<UserPersonalInfoDTO> optional = this.jpaMySQLUserRepository.getUserPersonalInfo(id);
        return this.checkOptional.checkOptionalOk(optional, "User");
    }

    @Override
    public List<UserPersonalInfoDTO> getAllDTO() {
        return this.jpaMySQLUserRepository.getAllDTO();
    }

    @Override
    public UserPersonalInfoDTO updateDTO(UserEditReqDTO body) throws NotFoundException{
        return this.usersDTOs.userPersonalInfoDTO(this.update(body));
    }
}
