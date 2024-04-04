package com.joel.spring.user.domain;

import com.joel.spring.accounttoken.domain.AccountToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserFirstName() {
        User user = new User();
        user.setFirstName("Joel");
        String expected = "Joel";
        String actual = user.getFirstName();

        assertEquals(expected, actual);
        assertTrue(actual.equals(expected));
    }

    @Test
    void testUserLastName() {
        User user = new User();
        user.setLastName("Rondinel Pacheco");
        String expected = "Rondinel Pacheco";
        String actual = user.getLastName();

        assertEquals(expected, actual);
        assertTrue(actual.equals(expected));
    }

    @Test
    void testUserEmail() {
        User user = new User();
        user.setEmail("joel@email.com");
        String expected = "joel@email.com";
        String actual = user.getEmail();

        assertEquals(expected, actual);
        assertTrue(actual.equals(expected));
    }

    @Test
    void testUserPassword() {
        User user = new User();
        user.setPassword("userPassword123");
        String expected = "userPassword123";
        String actual = user.getPassword();

        assertEquals(expected, actual);
        assertTrue(actual.equals(expected));
    }

    @Test
    void testUserAccountToken() {
        AccountToken accountToken = AccountToken.NewUserAccountToken("token");

        User user = new User();
        user.setAccountToken(accountToken);

        AccountToken actualAccountToken = user.getAccountToken();

        //todo add equals method
        assertEquals(accountToken, actualAccountToken);
    }
}