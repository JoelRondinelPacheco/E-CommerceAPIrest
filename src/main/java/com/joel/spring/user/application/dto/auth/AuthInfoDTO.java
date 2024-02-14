package com.joel.spring.user.application.dto.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AuthInfoDTO {
    private String response;
    private HttpStatusCode httpStatusCode;
    private List<AuthResDTO> errors;
}
