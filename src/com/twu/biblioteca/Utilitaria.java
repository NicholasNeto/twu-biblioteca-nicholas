package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Utilitaria {

    public Utilitaria() {
        createBookList();
        createFilmList();

    }

    public ArrayList<Book> createBookList() {

        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new Book("1", "TDD", "Kent", 2000));
        books.add(new Book("2", "Design Patterns", "Fowler", 2001));
        books.add(new Book("3", "Harry Potter", "Kent", 2002));
        books.add(new Book("4", "he Lord of the Rings", "Peter Jackson", 2003));

        return books;
    }

    public ArrayList<Movie> createFilmList() {

        ArrayList<Movie> movies = new ArrayList<Movie>();

        movies.add(new Movie("1", "A luz", "Nicholas", 2000));
        movies.add(new Movie("2", "Mochila Azul", "Nicols", 2001));
        movies.add(new Movie("3", "Harry Potter", "J. K. Rowling", 2002));
        movies.add(new Movie("4", "The Matrix", "Cara Incrivel", 2003));

        return movies;
    }

}
