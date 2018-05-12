package com.twu.biblioteca.util;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;

import java.util.ArrayList;

public class Utilitaria {

    public Utilitaria() {
        createItemsList();
        createListUserAndPassword();

    }

    public ArrayList<Item> createItemsList() {
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Book("1", "TDD", "Kent", 2000));
        items.add(new Book("2", "Design Patterns", "Fowler", 2001));
        items.add(new Book("3", "Harry Potter", "Kent", 2002));
        items.add(new Book("4", "The Lord of the Rings", "Peter Jackson", 2003));

        items.add(new Movie("5", "A luz", "Nicholas", 2000));
        items.add(new Movie("6", "Mochila Azul", "Nicols", 2001));
        items.add(new Movie("7", "Harry Potter", "J. K. Rowling", 2002));
        items.add(new Movie("8", "The Matrix", "Cara Incrivel", 2003));

        return items;
    }


    public ArrayList<User> createListUserAndPassword() {

        ArrayList<User> users = new ArrayList<User>();

        users.add(new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1313"));
        users.add(new User("12", "Thalyta", "Thalyta@gmail.com", 9899999, "12"));
        users.add(new User("123", "Erica", "Erica@gmail.com", 123456789, "123"));
        users.add(new User("1234", "Katia", "Katia@gmail.com", 123456789, "1234"));

        return users;
    }
}
