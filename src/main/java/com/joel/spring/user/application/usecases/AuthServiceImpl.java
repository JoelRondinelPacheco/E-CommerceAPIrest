package com.joel.spring.user.application.usecases;

import com.joel.spring.user.application.port.input.AuthService;
import com.joel.spring.user.application.usecases.utils.EmailVerification;
import com.joel.spring.user.application.usecases.utils.PasswordService;
import com.joel.spring.user.domain.User;
import com.joel.spring.user.dto.RegisterUserDTO;
import com.joel.spring.user.dto.UserCredentialsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private EmailVerification emailVerification; //TODO RENAME A EMAIL SERVICE O VERIFYEMAIL
    @Autowired
    private PasswordService passwordService;

    @Override
    public String login(UserCredentialsDTO userCredentials) {

        return  null;

        /*
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
        }*/
    }

    @Override
    public String register(RegisterUserDTO newUser) {
        this.emailVerification.existsOrThrows(newUser.getEmail());
        this.passwordService.equalsOrThrows(newUser.getPassword(), newUser.getRepeatedPassword());

        User user = new User();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPassword(this.passwordService.encrypt(newUser.getPassword()));

        //TODO CREATE CART


        return null;
        /*

        UserEntity userSaved = this.userService.save(user);
        CartEntity cartEntity = CartEntity.builder()
                .totalPrice(0D)
                .user(userSaved)
                .build();
        this.cartService.saveByEntity(cartEntity);
        response.setResponse("User registered");
        response.setErrors(errors);
        response.setHttpStatusCode(HttpStatus.CREATED);
        return response;
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);
    }*/

    }


}
