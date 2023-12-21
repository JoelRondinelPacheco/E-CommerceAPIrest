package com.joel.spring.config;

import com.joel.spring.validations.users.UserValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationsConfig {

    @Bean
    public UserValidation userValidation() {
        return new UserValidation();
    }
}
