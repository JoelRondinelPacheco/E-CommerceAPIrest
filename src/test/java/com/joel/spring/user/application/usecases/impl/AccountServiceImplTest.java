package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.accounttoken.application.usecases.AccountTokenVerificationUseCase;
import com.joel.spring.accounttoken.domain.AccountToken;
import com.joel.spring.user.application.port.input.AccountService;
import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.application.port.output.AuthRepositoryPort;
import com.joel.spring.user.domain.User;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {

    @Test
    void testValidateToken(){
        //creo usuario con token
        User user = new User();
        AccountToken accountToken = AccountToken.NewUserAccountToken("token");
        user.setAccountToken(accountToken);

        //simulo el repositorio
        UserSelector userSelector = mock(UserSelector.class);
        when(userSelector.byAccountToken("token")).thenReturn(user);

        AccountTokenVerificationUseCase accountTokenVerificationUseCase = mock(AccountTokenVerificationUseCase.class);
        doNothing().when(accountTokenVerificationUseCase).isValid(user.getAccountToken());
        doNothing().when(accountTokenVerificationUseCase).isValidationAccountToken(user.getAccountToken());

        AuthRepositoryPort userRepository = mock(AuthRepositoryPort.class);

        when(userRepository.update(user)).thenReturn(user);

        AccountService accountService = new AccountServiceImpl(accountTokenVerificationUseCase, userSelector, userRepository);

        String expectedResponse = "Account verification succesfully";

        assertEquals(expectedResponse, accountService.validate("token"));
    }

}