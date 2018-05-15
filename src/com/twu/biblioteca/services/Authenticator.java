package com.twu.biblioteca.services;


import com.twu.biblioteca.models.User;
import com.twu.biblioteca.util.Utilitaria;


import java.util.ArrayList;

public class Authenticator {

    private User user;
    Utilitaria util = new Utilitaria();
    ArrayList<User> userList = util.createListUserAndPassword();

    public User login(String idUser, String password) {

        for (User user : userList) {
            if (idUser.equals(user.getIdUser()) && password.equals(user.getPassword())) {

                user.setLogged(true);
                this.user = user;
                System.out.println("Welcome " + user.getName());
                System.out.println("Email: " + user.getEmail() + " Phone: " + user.getPhone());
            }
        }
        return user;
    }

    public User getUser() {
        return user;
    }

}
