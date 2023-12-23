package com.joel.spring.controllers;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public List<UserEntity> getAll () { return this.userService.getAll(); }

    @GetMapping("/{userId}")
    public ResponseEntity<UserPersonalInfoDTO> getById (@PathVariable String userId) throws NotFoundException {
        return new ResponseEntity<>(this.userService.getUserPersonalInfo(userId), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<String> delete(@PathVariable String clientId) {
        this.userService.delete(clientId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<UserEntity> edit(@RequestBody UserEditReqDTO body) throws NotFoundException {
        UserEntity userEntity = this.userService.update(body);
        return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
    }


}
