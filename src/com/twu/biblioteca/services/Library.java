package com.twu.biblioteca.services;

import com.twu.biblioteca.models.*;
import com.twu.biblioteca.util.Utilitaria;

import java.util.ArrayList;
import java.util.List;

public class Library {


    public ArrayList<Item> itemsList;


    private ArrayList<User> userList;
    private ArrayList<Item> itemList;

    public Library(User user) {

        Utilitaria util = new Utilitaria();
        itemList = util.createItemsList();

        userList = util.createListUserAndPassword();
        //this.user = user;

    }



    private String tableHeader = String.format("%20s %20s %20s %20s %20s\n", "ID", "Name", "Authors", "Years", "Status");


    public <T extends Item> String showMediaInTable(ArrayList<T> mediaList) {
        return tableHeader + getMediasAsString(mediaList);
    }

    public <T extends Item> String getMediasAsString(ArrayList<T> mediaList) {
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




    public ItemsLibrary getItemLibraryAvaible() {
        ArrayList<Book> listBookAvaible = new ArrayList<Book>();
        ArrayList<Movie> listMovieAvaible = new ArrayList<Movie>();

        for(Item item :itemList){
            if(item instanceof Book){
                if(item.getStatusEnum() == StatusEnum.AVAILABLE){
                    listBookAvaible.add((Book) item);
                }
            }else if(item instanceof Movie){
                if(item.getStatusEnum() == StatusEnum.AVAILABLE){
                    listMovieAvaible.add((Movie) item);
                }
            }
        }

        return new ItemsLibrary(listBookAvaible, listMovieAvaible);
    }



    public String borrowLibraryMedia(String id) {
        for(Item item :itemList){
            if(item.getId().equals(id)){
                if(item instanceof Book){
                    item.setStatusEnum(StatusEnum.UNAVAILABLE);
                    item.toString();
                    return "Thank you! Enjoy the book";
                }else if(item instanceof Movie){
                    item.setStatusEnum(StatusEnum.UNAVAILABLE);
                    return "Thank you! Enjoy the movie";
                }
            }
        }
        return "This book is not available";
    }

    public String returMediaToTheLibrary(String id) {
        for(Item item :itemList){
            if(item.getId().equals(id)){
                if(item instanceof Book){
//                    book.lendToUser(this.user);
                    item.setStatusEnum(StatusEnum.AVAILABLE);
                    return "Thank you for returning the Book";
                }else if(item instanceof Movie){
                    item.setStatusEnum(StatusEnum.AVAILABLE);
                    return "Thank you for returning the Movie";
                }
            }
        }
        return "This is not a valid Media to return";
    }



//    public String showUnavailableFilm() {
//        ArrayList<Movie> borrowedFilms = new ArrayList<Movie>();
//        for (Movie film : filmList) {
//            if (!film.isAvailable()) {
//                borrowedFilms.add(film);
//            }
//        }
//
//
//        return showMediaInTable(borrowedFilms);
//    }
//
//    public String showUnavailableBook() {
//        ArrayList<Book> borrowedBooks = new ArrayList<Book>();
//        for (Book book : bookList) {
//            if (!book.isAvailable()) {
//                borrowedBooks.add(book);
//            }
//        }
//        return showMediaInTable(borrowedBooks);
//    }

    public ItemsLibrary getItemsUnavailable(){
        ArrayList<Book> bookUnavailableList = new ArrayList<Book>();
        ArrayList<Movie> movieUnavailableList = new ArrayList<Movie>();
        for (Item item: itemList) {
            if(item instanceof Book){
                if(item.getStatusEnum() == StatusEnum.UNAVAILABLE){
                    bookUnavailableList.add((Book) item);
                }
            } else if(item instanceof Movie){
                if(item.getStatusEnum() == StatusEnum.UNAVAILABLE){
                    movieUnavailableList.add((Movie) item);
                }
            }
        }

        ItemsLibrary itemsLibrary = new ItemsLibrary();
        itemsLibrary.setBookList(bookUnavailableList);
        itemsLibrary.setMovieList(movieUnavailableList);

        return itemsLibrary;
    }


//    public StatusEnum showItemAvailability(Item item) {
//
//        //Instance of, fazer o mesmo para o movie
//
//        if(item instanceof Book ){
//            Book book = (Book) item;
//            return bookList.get(bookList.indexOf(book)).getStatusEnum();
//        } else if (item instanceof Movie) {
//            Movie movie = (Movie) item;
//            return filmList.get(filmList.indexOf(movie)).getStatusEnum();
//        } else {
//            return StatusEnum.UNAVAILABLE;
//        }
//
//    }

//    public void setBookList(ArrayList<Book> bookList) {
//        this.bookList = bookList;
//    }
//
//    public void setFilmList(ArrayList<Movie> filmList) {
//        this.filmList = filmList;
//    }
}