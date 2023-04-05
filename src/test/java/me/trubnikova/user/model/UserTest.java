package me.trubnikova.user.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static final String TRUE_LOGIN = "Login";
    private static final String LOGIN_EMPTY = "";
    private static final String LOGIN_BLANK = "     ";
    private static final String TRUE_EMAIL = "email@mail.ru";
    private static final String FALLS_EMAIL_WITHOUT_AT = "emailmail.ru";
    private static final String FALLS_EMAIL_WITHOUT_DOT = "email@mailru";

    @Test
    public void shouldCreateUserObjectWithTwoParameters() {
        User result = new User(TRUE_LOGIN, TRUE_EMAIL);
        Assertions.assertNotNull(result);
    }

    @Test
    public void shouldCreateUserObjectWithNoParameters() {
        User result = new User();
        Assertions.assertNotNull(result);
    }

    @Test
    public void shouldEmailContainsAtAndDot() {
        User result = new User(TRUE_LOGIN, TRUE_EMAIL);
        Assertions.assertTrue(result.getEmail().contains("@")
                && result.getEmail().contains("."));
    }

    @Test
    public void shouldNotBeEqualLoginAndEmail() {
        User result = new User(TRUE_LOGIN, TRUE_EMAIL);
        Assertions.assertNotEquals(result.getLogin(), result.getEmail());
    }

    @Test
    public void expectedExceptionEmailNoContainsAt() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User result = new User(TRUE_LOGIN, FALLS_EMAIL_WITHOUT_AT);
        });
    }

    @Test
    public void expectedExceptionEmailNoContainsDot() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User result = new User(TRUE_LOGIN, FALLS_EMAIL_WITHOUT_DOT);
        });
    }

    @Test
    public void expectedIllegalArgumentExceptionWhenEmailEqualsLogin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User result = new User(TRUE_EMAIL, TRUE_EMAIL);
        });
    }

    @Test
    public void expectedIllegalArgumentExceptionWhenLoginIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User result = new User(LOGIN_EMPTY, TRUE_EMAIL);
        });
    }

    @Test
    public void expectedIllegalArgumentExceptionWhenLoginIsBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User result = new User(LOGIN_BLANK, TRUE_EMAIL);
        });
    }

}