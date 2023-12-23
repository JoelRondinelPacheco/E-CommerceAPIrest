package com.joel.spring.services.impl;

import com.joel.spring.dtos.users.*;
import com.joel.spring.entities.Cart;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.IAuthService;
import com.joel.spring.services.ICartService;
import com.joel.spring.services.IJWTUtilityService;
import com.joel.spring.services.IUserService;
import com.joel.spring.validations.users.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService implements IAuthService {

    @Autowired private IUserService userService;
    @Autowired private IJWTUtilityService jwtUtilityService;
    @Autowired private UserValidation userValidation;
    @Autowired private ICartService cartService;

    @Override
    public AuthInfoDTO login(LoginDTO login) {
        List<AuthResDTO> errors = new ArrayList<>();
        AuthInfoDTO response = new AuthInfoDTO();
        try {
            UserEntity user = this.userService.findByEmail(login.getEmail());
            if (verifyPassword(login.getPassword(), user.getPassword())) {
                response.setResponse(jwtUtilityService.generateJWT(user.getId()));
                response.setErrors(errors);
                response.setHttpStatusCode(HttpStatus.OK);
            } else {
                errors.add(new AuthResDTO("error", "User or password invalid"));
                response.setResponse("Error");
                response.setErrors(errors);
                response.setHttpStatusCode(HttpStatus.UNAUTHORIZED);
            }
            return response;
        } catch (NotFoundException e) {
            errors.add(new AuthResDTO("error", "User or password invalid"));
            response.setResponse("Error");
            response.setErrors(errors);
            response.setHttpStatusCode(HttpStatus.UNAUTHORIZED);
            return response;
        }
        catch (Exception e) {
            errors.add(new AuthResDTO("error", e.getMessage()));
            response.setResponse("Error");
            response.setErrors(errors);
            response.setHttpStatusCode(HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    @Override
    public AuthInfoDTO register(UserPostReqDTO user) {
        List<AuthResDTO> errors = new ArrayList<>();
        AuthInfoDTO response = new AuthInfoDTO();
        boolean exists = this.userService.existsByEmail(user.getEmail());
        if (exists) {
            errors.add(new AuthResDTO("error", "User already exists"));
            response.setErrors(errors);
            response.setHttpStatusCode(HttpStatus.CONFLICT);
            return response;
        }

        UserEntity userSaved = this.userService.save(user);
        Cart cart = Cart.builder()
                .totalPrice(0D)
                .user(userSaved)
                .build();
        this.cartService.saveByEntity(cart);
        response.setResponse("User registered");
        response.setErrors(errors);
        response.setHttpStatusCode(HttpStatus.CREATED);
        return response;
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);
    }

}
