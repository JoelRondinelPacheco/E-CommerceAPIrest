package com.joel.spring.mail.adapter.output.mail;


import com.joel.spring.mail.application.dto.MailSenderDTO;
import com.joel.spring.mail.application.dto.SendMailDTO;
import com.joel.spring.mail.application.port.output.MailServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailServiceAdapter implements MailServicePort {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String send(MailSenderDTO mailDTO) {
        try {
            System.out.println("entro a envuar mail");
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(mailDTO.getMailFrom());
            mail.setTo(mailDTO.getTo());
            mail.setSubject(mailDTO.getSubject());
            mail.setText(mailDTO.getMessage());
            System.out.println("Antes de enviarlo");
            mailSender.send(mail);
            System.out.println("Despues de enviarlo");
            return "Mail enviado correctamente a: " + mailDTO.getTo();
        } catch (MailException ex) {
            return "Error al enviar mail: " + ex.getMessage();
        }
    }
}
