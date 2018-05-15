package com.twu.biblioteca.services;

import com.twu.biblioteca.models.*;
import com.twu.biblioteca.util.MessagesUtil;
import com.twu.biblioteca.util.Utilitaria;

import java.util.ArrayList;


public class Library {


    private ArrayList<Item> itemsList;

    public Library() {
        Utilitaria util = new Utilitaria();
        itemsList = util.createItemsList();
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

    public String borrowLibraryMedia(String id) {
        String message = "LOL";

        for(Item item :itemsList){
            if(item.getId().equals(id)){
                if(item instanceof Book){
                    if(item.getStatusEnum() == StatusEnum.AVAILABLE){
                        item.setStatusEnum(StatusEnum.UNAVAILABLE);
                        message = MessagesUtil.SUCCESS_BOOK_BORED;
                    } else {
                        message = "That book is not available.";
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

    public String returnMediaToTheLibrary(String id) {

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

    public ItemsLibrary getItemsByStatus(StatusEnum statusEnum){
        ArrayList<Book> booksList = new ArrayList<Book>();
        ArrayList<Movie> moviesList = new ArrayList<Movie>();

        for (Item item: itemsList) {
            if(item instanceof Book){
                if(item.getStatusEnum().equals(statusEnum)){
                    booksList.add((Book) item);
                }
            } else if(item instanceof Movie){
                if(item.getStatusEnum().equals(statusEnum)){
                    moviesList.add((Movie) item);
                }
            }
        }

        return new ItemsLibrary(booksList, moviesList);
    }

}