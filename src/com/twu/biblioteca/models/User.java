package com.twu.biblioteca;

public class User {

    private String idUser;
    private String name;
    private String email;
    private int phone;
    private String password;

    public User(String idUser, String name, String email, int phone, String password) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getIdUser() { return idUser; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public int getPhone() { return phone; }

    public String getPassword() { return password; }
}