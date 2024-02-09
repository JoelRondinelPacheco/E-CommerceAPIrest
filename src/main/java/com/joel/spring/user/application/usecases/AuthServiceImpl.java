package com.joel.spring.user.application.usecases;

import com.joel.spring.user.application.port.input.AuthService;
import com.joel.spring.user.application.usecases.utils.EmailVerification;
import com.joel.spring.user.dto.RegisterUserDTO;
import com.joel.spring.user.dto.UserCredentialsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private EmailVerification emailVerification;

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
        //TODO EVALUAR SI ES MEJOR LANZAR EXPECION Y SOLO LLAMAR AL METODO
        if (emailVerification.exists(newUser.getEmail())) {
            //TODO THROW EXCEPTION
        }

        //TODO VERIFICAR QUE LAS CONTRASEÑAS SEAN IGUALES, OTRO METODO? CREO QUE SI PORQUE TAMBIEN SE USA AL RESETEAR PASSWORD
        return null;

        /*List<AuthResDTO> errors = new ArrayList<>();
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
    }*/

    }


}
