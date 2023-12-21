package com.joel.spring.controllers;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> crate(@RequestBody UserPostReqDTO body) {
        return new ResponseEntity<UserEntity>(this.clientService.save(body), HttpStatus.OK);
    }

    @GetMapping
    public List<UserEntity> getAll () { return this.clientService.getAll(); }

    @GetMapping("/{client_id}")
    public ResponseEntity<UserEntity> getById (@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<UserEntity>(this.clientService.getById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{client_id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.clientService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("edit/{client_id}")
    public ResponseEntity<UserEntity> edit(@RequestBody UserEditReqDTO body) throws NotFoundException {
        UserEntity userEntity = this.clientService.update(body);
        return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
    }


}
