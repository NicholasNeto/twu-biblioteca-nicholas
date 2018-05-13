package com.twu.biblioteca.services;

import com.twu.biblioteca.models.*;
import com.twu.biblioteca.util.Utilitaria;

import java.util.ArrayList;


public class Library {



    private ArrayList<Item> itemsList;
    private ArrayList<User> userList;


    public Library(User user) {

        Utilitaria util = new Utilitaria();
        itemsList = util.createItemsList();
        userList = util.createListUserAndPassword();

    }

    public ArrayList<Item> getItemsList() {
        return itemsList;
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

        for(Item item :itemsList){
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
        String message = "LOL";

        for(Item item :itemsList){
            if(item.getId().equals(id)){
                if(item instanceof Book){
                    if(item.getStatusEnum() == StatusEnum.AVAILABLE){
                        item.setStatusEnum(StatusEnum.UNAVAILABLE);
                        message =  "Thank you! Enjoy the book";
                    } else {
                        message =  "That book is not available.";
                    }

                }else if(item instanceof Movie){
                    if(item.getStatusEnum() == StatusEnum.AVAILABLE){
                        item.setStatusEnum(StatusEnum.UNAVAILABLE);
                        message =  "Thank you! Enjoy the movie";
                    } else{
                        message = "That movie  is not available.";
                    }
                }
            }
        }
        return message;
    }

    public String returMediaToTheLibrary(String id) {

        String message = "LOL";

        for(Item item :itemsList){
            if(item.getId().equals(id)){
                if(item instanceof Book){
                    if(item.getStatusEnum() == StatusEnum.UNAVAILABLE){
                        item.setStatusEnum(StatusEnum.AVAILABLE);
                        message =  "Thank you for returning the book";
                    } else {
                        message =  "This is not a valid book to return";
                    }
                }else if(item instanceof Movie){

                    if(item.getStatusEnum() == StatusEnum.UNAVAILABLE){
                        item.setStatusEnum(StatusEnum.AVAILABLE);
                        message =  "Thank you for returning the movie";
                    } else {
                        message =  "This is not a valid movie to return";
                    }
                }
            }
        }
        return message;
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

        for (Item item: itemsList) {
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