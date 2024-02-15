package com.joel.spring.user.application.usecases.impl;

import com.joel.spring.mail.application.dto.SendMailDTO;
import com.joel.spring.mail.application.port.input.MailService;
import com.joel.spring.user.application.port.input.AccountService;
import com.joel.spring.accounttoken.application.port.input.TokenSelector;
import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.application.port.output.AccountTokenPersistencePort;
import com.joel.spring.accounttoken.application.port.output.AuthRepositoryPort;
import com.joel.spring.accounttoken.application.usecases.AccountTokenVerificationUseCase;
import com.joel.spring.accounttoken.application.usecases.impl.ForgotPasswordTokenUseCaseImpl;
import com.joel.spring.user.application.usecases.utils.EmailVerification;
import com.joel.spring.user.application.usecases.utils.PasswordService;
import com.joel.spring.accounttoken.domain.AccountToken;
import com.joel.spring.user.domain.User;
import com.joel.spring.user.application.dto.auth.PasswordsDTO;
import com.joel.spring.user.application.dto.auth.ResetPasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AuthRepositoryPort userRepository;
    @Autowired
    private AccountTokenVerificationUseCase accountTokenVerifier;
    @Autowired
    private UserSelector userSelector;
    @Autowired
    private TokenSelector tokenSelector;
    @Autowired
    private ForgotPasswordTokenUseCaseImpl forgotPasswordToken;
    @Autowired
    private EmailVerification emailVerification;
    @Autowired
    private AccountTokenPersistencePort accountTokenPersistencePort;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private MailService mailService;

    private String accountVerificationOk = "Account verification succesfully";
    private String forgotPasswordMessage = "Forgot password message response";
    private String resetPasswordOkMessage = "Reset password ok message";

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

        this.emailVerification.existsOrThrows(email);
        this.emailVerification.isValidORThrows(email);

        AccountToken accountToken = this.tokenSelector.getByUserEmail(email);

        this.forgotPasswordToken.updateToken(accountToken);
        AccountToken accountTokenSaved = this.accountTokenPersistencePort.save(accountToken);

        SendMailDTO mail = new SendMailDTO(email, "Reset password", accountTokenSaved.getToken());
        this.mailService.sendForgotPassword(mail);

        return this.getForgotPasswordMessage();
    }

    @Override
    public String resetPassword(ResetPasswordDTO resetPasswordDTO) {
        AccountToken accountToken = this.tokenSelector.getByToken(resetPasswordDTO.getToken());

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

    private String getAccountVerificationOk() {
        return this.accountVerificationOk;
    }
    private String getForgotPasswordMessage() { return this.forgotPasswordMessage; }
    private String getResetPasswordOkMessage() { return this.resetPasswordOkMessage; }
}
