package com.joel.spring.dtos.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AuthResDTO {
    private String response;
    private List<InvalidFieldDTO> errors;
}
