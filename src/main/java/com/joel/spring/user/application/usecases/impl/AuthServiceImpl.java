package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.cart.application.port.input.CartService;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.user.application.dto.auth.*;
import com.joel.spring.user.application.port.input.AuthService;
import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.application.port.output.AuthRepositoryPort;
import com.joel.spring.user.application.port.output.UserDTOSelectorPort;
import com.joel.spring.user.application.usecases.accounttoken.NewAccountTokenUseCase;
import com.joel.spring.security.JWTUtilityService;
import com.joel.spring.user.application.usecases.utils.EmailVerification;
import com.joel.spring.user.application.usecases.utils.PasswordService;
import com.joel.spring.user.domain.AccountToken;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private String accountRegisteredMessage = "User registered, check your email";

    @Autowired
    private AuthRepositoryPort authRepository;
    @Autowired
    private EmailVerification emailVerification; //TODO RENAME A EMAIL SERVICE O VERIFYEMAIL
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private JWTUtilityService jwtService;
    @Autowired
    private CartService cartService;
    @Autowired
    @Qualifier("newAccount")
    private NewAccountTokenUseCase newUserAccountToken;
    @Autowired
    private UserDTOSelectorPort userDTORepository;

    @Autowired
    private UserSelector userSelector;

    @Override
    public String login(UserCredentialsDTO userCredentials) {
    //TODO AGREGAR EXEPCIONES EN REPO
        LoginPersistenceInfoDTO user = this.userDTORepository.loginInfo(userCredentials.getEmail());

        this.passwordService.checkLoginPasswordsOrThrows(new LoginPasswordsDTO(userCredentials.getPassword(), user.getPassword()));

        return this.jwtService.generateJWT(user.getId());
    }

    @Override
    public String register(RegisterUserDTO newUser) {

        this.emailVerification.existsOrThrows(newUser.getEmail());
        this.passwordService.equalsOrThrows(new PasswordsDTO(newUser.getPassword(), newUser.getRepeatedPassword()));

        User user = this.create(newUser);

        Cart cart = this.cartService.create();
        AccountToken accountToken = this.newUserAccountToken.create();

        user.setCart(cart);
        user.setAccountToken(accountToken);

        User userRegistered = this.authRepository.register(user);

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
