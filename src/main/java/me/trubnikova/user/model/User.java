package me.trubnikova.user.model;

import org.springframework.util.StringUtils;

public class User {

    private String login;
    private String email;

    public User(String login, String email) {
        this.login = validateLogin(login);
        this.email = validateEmail(email);
    }

    public User() {
    }

    public String validateLogin(String value) {
        if (value == null || value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException("Поле Логин заполнено некорректно");
        } else {
            return value;
        }
    }

    public String validateEmail(String value) {
        if (value == null || value.isEmpty() || value.isBlank() || !value.contains("@") || !value.contains(".")) {
            throw new IllegalArgumentException("Поле E-mail заполнено некорректно");
        }
        if (value.equals(login)) {
            throw new IllegalArgumentException("Поля E-mail и Логин совподают");
        } else {
            return value;
        }
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
