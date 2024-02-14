package com.joel.spring.user.application.port.output;

import com.joel.spring.user.domain.User;

public interface UserSelectorPort {
    User byEmail(String userEmail);
    User byId(String userId);
    User byAccountToken(String accountToken);

}
