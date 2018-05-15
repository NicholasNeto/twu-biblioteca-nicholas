package com.twu.biblioteca.models;

import java.util.ArrayList;

public class ItemsLibrary {

    public ItemsLibrary(ArrayList<Book> bookList, ArrayList<Movie> movieList) {
        this.bookList = bookList;
        this.movieList = movieList;
    }

    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }


}
