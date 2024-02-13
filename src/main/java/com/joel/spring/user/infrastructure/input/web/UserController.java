package com.joel.spring.user.infrastructure.input.web;

import com.joel.spring.user.application.port.input.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class UserController {
    @Autowired
    private UserService userService;
/*
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
    }*/
}
