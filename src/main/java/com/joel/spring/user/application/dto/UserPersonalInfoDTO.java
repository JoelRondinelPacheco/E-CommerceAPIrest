package com.joel.spring.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
public class UserPersonalInfoDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public UserPersonalInfoDTO(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
