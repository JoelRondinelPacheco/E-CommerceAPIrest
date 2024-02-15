package com.joel.spring.mail.application.dto;

public class MailSenderDTO extends SendMailDTO{
    private String mailFrom;

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public MailSenderDTO(String to, String subject, String message, String mailFrom) {
        super(to, subject, message);
        this.mailFrom = mailFrom;
    }

    public MailSenderDTO(String mailFrom) {
        this.mailFrom = mailFrom;
    }
}
