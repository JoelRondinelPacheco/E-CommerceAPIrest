package com.joel.spring.controllers;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> crate(@RequestBody UserPostReqDTO body) {
        return new ResponseEntity<UserEntity>(this.userService.save(body), HttpStatus.OK);
    }

    @GetMapping
    public List<UserEntity> getAll () { return this.userService.getAll(); }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getById (@PathVariable String userId) throws NotFoundException {
        return new ResponseEntity<UserEntity>(this.userService.getById(userId), HttpStatus.FOUND);
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
