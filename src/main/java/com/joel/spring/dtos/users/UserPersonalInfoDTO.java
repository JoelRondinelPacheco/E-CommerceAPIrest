package com.joel.spring.dtos.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserPersonalInfoDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
