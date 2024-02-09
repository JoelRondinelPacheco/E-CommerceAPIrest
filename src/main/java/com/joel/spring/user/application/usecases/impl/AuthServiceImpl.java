package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.cart.application.port.input.CartService;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.user.application.port.input.AuthService;
import com.joel.spring.user.application.port.output.AuthRepositoryPort;
import com.joel.spring.user.application.usecases.AccountTokenUseCase;
import com.joel.spring.user.application.usecases.JWTUtilityService;
import com.joel.spring.user.application.usecases.utils.EmailVerification;
import com.joel.spring.user.application.usecases.utils.PasswordService;
import com.joel.spring.user.domain.AccountToken;
import com.joel.spring.user.domain.User;
import com.joel.spring.user.dto.LoginPasswordsDTO;
import com.joel.spring.user.dto.PasswordsDTO;
import com.joel.spring.user.dto.RegisterUserDTO;
import com.joel.spring.user.dto.UserCredentialsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private String accountRegisteredMessage = "User registered, check your email";

    @Autowired
    private EmailVerification emailVerification; //TODO RENAME A EMAIL SERVICE O VERIFYEMAIL
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private AuthRepositoryPort authRepository;
    @Autowired
    private JWTUtilityService jwtService;
    @Autowired
    private CartService cartService;

    @Autowired
    @Qualifier("newAccount")
    private AccountTokenUseCase newUserAccountToken;

    @Override
    public String login(UserCredentialsDTO userCredentials) {

        User user = this.authRepository.getUserByEmail(userCredentials.getEmail());

        this.passwordService.checkLoginPasswordsOrThrows(new LoginPasswordsDTO(userCredentials.getPassword(), user.getPassword()));
        String jwt = this.jwtService.generateJWT(user.getId());

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
        this.passwordService.equalsOrThrows(new PasswordsDTO(newUser.getPassword(), newUser.getRepeatedPassword()));

        User user = this.create(newUser);
        User userRegistered = this.authRepository.register(user);

        Cart cart = this.cartService.createFor(user);
        AccountToken accountToken = this.newUserAccountToken.create();

        userRegistered.setCart(cart);
        userRegistered.setAccountToken(accountToken);

        this.authRepository.registrationUpdate(userRegistered);

        //TODO SEND EMAIL


        return this.getAccountRegisteredOkMessage();
    }

    private User create(RegisterUserDTO newUser) {
        User user = new User();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPassword(this.passwordService.encrypt(newUser.getPassword()));

        return user;
    }

    private String getAccountRegisteredOkMessage() {
        return this.accountRegisteredMessage;
    }
}
