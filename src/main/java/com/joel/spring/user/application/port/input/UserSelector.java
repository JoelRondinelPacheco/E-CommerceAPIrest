package com.joel.spring.user.application.port.input;

import com.joel.spring.user.domain.User;

public interface UserSelector{
    User byEmail(String userEmail);
    User byId(String userId);
    User byAccountToken(String accountToken);
    User referenceById(String id);
}
