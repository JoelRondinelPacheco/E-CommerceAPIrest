package com.joel.spring.mail.application.port.output;

import com.joel.spring.mail.application.dto.MailSenderDTO;
import com.joel.spring.mail.application.dto.SendMailDTO;

public interface MailServicePort {
    String send(MailSenderDTO mail);
}
