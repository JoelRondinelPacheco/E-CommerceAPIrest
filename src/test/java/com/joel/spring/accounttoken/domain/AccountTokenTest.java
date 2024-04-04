package com.joel.spring.accounttoken.domain;

import com.joel.spring.user.util.AccountTokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTokenTest {

    @Test
    void testAccountTokenConstructor() {
        AccountToken accountToken = AccountToken.NewUserAccountToken("token");

        String expectedToken = "token";
        String actualToken = accountToken.getToken();

        AccountTokenType expectedAccountTokenType = AccountTokenType.VALIDATE_ACCOUNT;
        AccountTokenType actualAccountTokenType = accountToken.getTokenType();

        boolean expectedValid = true;
        boolean actualValid = accountToken.isValid();

        assertEquals(expectedToken, actualToken);
        assertTrue(actualToken.equals(expectedToken));

        assertEquals(expectedAccountTokenType, actualAccountTokenType);

        assertTrue(expectedValid == actualValid);
        assertSame(expectedValid, actualValid);
    }

}