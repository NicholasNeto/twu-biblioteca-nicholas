package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> bookList;
    List<Movie> filmList;
    private List<User> userList = new ArrayList<User>();

    private User user;

    public Library() {

        Utilitaria util = new Utilitaria();
        bookList = util.createBookList();
        filmList = util.createFilmList();
    }

    protected void createListUserAndPassword() {
        User user1 = new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1");
        User user2 = new User("12", "Thalyta", "Thalyta@gmail.com", 9899999, "12");
        User user3 = new User("123", "Erica", "Erica@gmail.com", 123456789, "123");
        User user4 = new User("1234", "Katia", "Katia@gmail.com", 123456789, "1234");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
    }

    private boolean logged = false;

    public boolean isLogged() {
        return this.logged;
    }

    public boolean login(String idUser, String password) {
        for (User user : userList) {
            if (idUser.equals(user.getIdUser()) && password.equals(user.getPassword())) {
                logged = true;
                this.user = user;
                System.out.println("Welcome " + user.getName());
                System.out.println("Email: " + user.getEmail() + " Phone: " + user.getPhone());
            }
        }
        return logged;
    }

    private String tableHeader = String.format("%20s %20s %20s %20s  %20s\n", "ID", "Name", "Authors", "Years",  "Status");

    public <T extends Item> String showMediaInTable(List<T> mediaList) {
        return tableHeader + getMediasAsString(mediaList);
    }

    public <T extends Item> String getMediasAsString(List<T> mediaList) {
        String representation = "";

        for (Item media : mediaList) {

            if (representation.isEmpty()) {

                representation += media.toString();

            } else {
                representation += "\n" + media.toString();
            }
        }
        return representation;
    }

    public String borrowLibraryFilm(String id) {

        for (Movie film : this.filmList) {
            if (id.equals(film.getId())) {
                film.lendToUser(this.user);
                return "Thank you! Enjoy the film";
            }
        }
        return "This film is not available";
    }

    public String borrowLibraryBook(String id) {
        for (Book book : this.bookList) {
            if (id.equals(book.getId())) {
                book.lendToUser(this.user);
                return "Thank you! Enjoy the book";
            }
        }
        return "This book is not available";
    }

    public String returnFilmToTheLibrary(String id) {
        for (Movie film : this.filmList) {
            if (id.equals(film.getId())) {
                film.setReturn();
                return "Thank you for returning the film";
            }
        }
        return "This is not a valid film to return";
    }

    public String returnBookToTheLibrary(String id) {

        for (Item book : this.bookList) {
            if (id.equals(book.getId())) {
                book.setReturn();
                return "Thank you for returning the book";
            }
        }
        return "This is not a valid book to return";
    }

    public String showUnavailableFilm() {
        List<Movie> borrowedFilms = new ArrayList<Movie>();
        for (Movie film : filmList) {
            if (!film.isAvailable()) {
                borrowedFilms.add(film);
            }
        }
        return showMediaInTable(borrowedFilms);
    }

    public String showUnavailableBook() {
        List<Book> borrowedBooks = new ArrayList<Book>();
        for (Book book : bookList) {
            if (!book.isAvailable()) {
                borrowedBooks.add(book);
            }
        }
        return showMediaInTable(borrowedBooks);
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setFilmList(List<Movie> filmList) {
        this.filmList = filmList;
    }
}