package com.joel.spring.mail.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMailDTO {
    private String to;
    private String subject;
    private String message;
}
