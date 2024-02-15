package com.joel.spring.mail.application.port.input;

import com.joel.spring.mail.application.dto.SendMailDTO;

public interface MailService {

    String sendRegisterEmail(SendMailDTO info);
    String send(SendMailDTO mail);
}
