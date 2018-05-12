package com.twu.biblioteca.models;

import java.util.ArrayList;

public class ItemsLibrary {

    public ItemsLibrary(ArrayList<Book> bookList, ArrayList<Movie> movieList) {
        this.bookList = bookList;
        this.movieList = movieList;
    }

    public ItemsLibrary() {
    }

    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }
}
