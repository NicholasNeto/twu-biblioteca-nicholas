package com.twu.biblioteca.models;

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

    private boolean logged = false;

    public String getIdUser() { return idUser; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public int getPhone() { return phone; }

    public String getPassword() { return password; }


    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public boolean equals(Object obj) {

        User user = (User) obj;

        if(user.getIdUser().equals( this.idUser)
                && user.getName().equals(this.name)
                && user.getEmail().equals(this.email)
                && user.getPhone() == this.phone
                && user.getPassword().equals(this.password))
        {
            return true;
        }
            return false;
    }
}