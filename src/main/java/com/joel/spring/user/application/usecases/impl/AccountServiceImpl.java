package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.user.application.port.input.AccountService;
import com.joel.spring.accounttoken.application.port.input.TokenSelector;
import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.application.port.output.AccountTokenPersistencePort;
import com.joel.spring.accounttoken.application.port.output.AuthRepositoryPort;
import com.joel.spring.accounttoken.application.usecases.AccountTokenVerificationUseCase;
import com.joel.spring.accounttoken.application.usecases.impl.ForgotPasswordTokenUseCaseImpl;
import com.joel.spring.user.application.usecases.utils.EmailVerification;
import com.joel.spring.user.application.usecases.utils.PasswordService;
import com.joel.spring.user.domain.AccountToken;
import com.joel.spring.user.domain.User;
import com.joel.spring.user.application.dto.auth.PasswordsDTO;
import com.joel.spring.user.application.dto.auth.ResetPasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AccountServiceImpl implements AccountService {
/*
TODO copiar de aca el metodo apra buscar por token
    @Autowired
    private AccountTokenRepository accountTokenRepository;*/

    @Autowired
    private AuthRepositoryPort userRepository;
    @Autowired
    private AccountTokenVerificationUseCase accountTokenVerifier;

    @Autowired
    @Qualifier("accountTokenByToken")
    private TokenSelector<String> tokenByAccountToken;
    @Autowired
    private UserSelector userSelector;
    @Autowired
    @Qualifier("tokenByUserEmail")
    private TokenSelector<String> tokenByUserEmail;
    @Autowired
    private ForgotPasswordTokenUseCaseImpl forgotPasswordToken;
    @Autowired
    private EmailVerification emailVerification;
    @Autowired
    private AccountTokenPersistencePort accountTokenPersistencePort;
    @Autowired
    private PasswordService passwordService;

    private String accountVerificationOk = "Account verification succesfully";
    private String forgotPasswordMessage = "Forgot password message response";
    private String resetPasswordOkMessage = "Reset password ok message";
    /*
    TODO
        Create account token whit jwt
     */
    @Override
    public String validate(String token) {
        User user = this.userSelector.byAccountToken(token);

        this.accountTokenVerifier.isValid(user.getAccountToken());
        this.accountTokenVerifier.isValidationAccountToken(user.getAccountToken());

        user.setVerified(true);
        user.getAccountToken().setValid(false);
        this.userRepository.update(user);

        return this.getAccountVerificationOk();
    }

    @Override
    public String forgotPassword(String email) {
        //TODO COMBINE IN ONE METHOD
        this.emailVerification.existsOrThrows(email);
        this.emailVerification.isValidORThrows(email);

        AccountToken accountToken = this.tokenByUserEmail.get(email);

        this.forgotPasswordToken.updateToken(accountToken);
        this.accountTokenPersistencePort.save(accountToken);

        //TODO handle exception

        /*
        TODO
            send email
         */
        return this.getForgotPasswordMessage();
    }

    @Override
    public String resetPassword(ResetPasswordDTO resetPasswordDTO) {
        AccountToken accountToken = this.tokenByAccountToken.get(resetPasswordDTO.getToken());

        this.accountTokenVerifier.verifyToken(accountToken);
        this.accountTokenVerifier.isResetPasswordToken(accountToken);

        User user = this.userSelector.byAccountToken(resetPasswordDTO.getToken());

        PasswordsDTO passwords = new PasswordsDTO(resetPasswordDTO.getPassword(), resetPasswordDTO.getRepeatedPassword());
        this.passwordService.equalsOrThrows(passwords);

        String newPassword = this.passwordService.encrypt(resetPasswordDTO.getPassword());
        user.setPassword(newPassword);

        accountToken.setValid(false);

        this.userRepository.update(user);

        return this.getResetPasswordOkMessage();
    }

    private void checkUserAccountVerified(User user) {
        if (!user.isVerified()) {
            throw new RuntimeException("TODO CUSTOM EX");
        }
    }


    private String getAccountVerificationOk() {
        return this.accountVerificationOk;
    }
    private String getForgotPasswordMessage() { return this.forgotPasswordMessage; }
    private String getResetPasswordOkMessage() { return this.resetPasswordOkMessage; }
}
