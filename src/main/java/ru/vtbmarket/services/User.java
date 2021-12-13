package ru.vtbmarket.services;

public class User {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String username;

    public String getEmail() {
        return email;
    }

    public boolean checkPassword(String s) {
        return true; // для целей учебного проекта обходим стороной вопрос авторизации
    }

    public User(int id, String name, String lastName, String email, String password, String username) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
