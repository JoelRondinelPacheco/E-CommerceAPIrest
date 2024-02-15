package com.joel.spring.mail.application.usecases;

import com.joel.spring.mail.application.dto.MailSenderDTO;
import com.joel.spring.mail.application.dto.SendMailDTO;
import com.joel.spring.mail.application.port.input.MailService;
import com.joel.spring.mail.application.port.output.MailServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailServicePort mailSender;

    @Value("$(spring.email.username)")
    private String fromMail;

    @Override
    public String sendRegisterEmail(SendMailDTO info) {
        return this.send(info);
    }

    @Override
    public String sendForgotPassword(SendMailDTO info) {
        return null;
    }

    @Override
    public String send(SendMailDTO mailDTO) {
        MailSenderDTO info = new MailSenderDTO(mailDTO.getTo(), mailDTO.getSubject(), mailDTO.getMessage(), fromMail);
        return this.mailSender.send(info);
    }
}
