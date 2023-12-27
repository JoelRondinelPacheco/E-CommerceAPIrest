package com.joel.spring.controllers;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    public List<UserPersonalInfoDTO> getAll () { return this.userService.getAllDTO(); }

    @GetMapping("/{userId}")
    public ResponseEntity<UserPersonalInfoDTO> getById (@PathVariable String userId) throws NotFoundException {
        return new ResponseEntity<>(this.userService.getUserPersonalInfo(userId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> delete(@PathVariable String userId) {
        this.userService.delete(userId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<UserPersonalInfoDTO> edit(@RequestBody UserEditReqDTO body) throws NotFoundException {
        return new ResponseEntity<>(this.userService.updateDTO(body), HttpStatus.OK);
    }


}
