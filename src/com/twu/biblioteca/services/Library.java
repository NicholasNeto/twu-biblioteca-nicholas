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
                        message = MessagesUtil.SUCCESS_BOOK_BORROWED;
                    } else {
                        message = MessagesUtil.FAILURE_BOOK_BORROWED;
                    }

                }else if(item instanceof Movie){
                    if(item.getStatusEnum() == StatusEnum.AVAILABLE){
                        item.setStatusEnum(StatusEnum.UNAVAILABLE);
                        message = MessagesUtil.SUCCESS_MOVIE_BORROWED;
                    } else{
                        message = MessagesUtil.FAILURE_MOVIE_BORROWED;
                    }
                }
            }
        }
        return message;
    }

    public String returnMediaToTheLibrary(String id) {

        String message = "LOL";

        for(Item item :itemsList) {
            if (item.getId().equals(id)) {
                if (item.getStatusEnum().equals(StatusEnum.UNAVAILABLE)) {
                    item.setStatusEnum(StatusEnum.AVAILABLE);
                    message = MessagesUtil.RETURN_MEDIA_SUCCESSFULLY;
                } else {
                    message = MessagesUtil.FAILED_BOOK_RETURN;
                }
            }
        }
        return message;
    }


    public <T> ArrayList<Item > getItemsByStatus(StatusEnum statusEnum, Class<T> clazz ){
        ArrayList<Item> listItem = new  ArrayList<Item>();
        for (Item item: itemsList) {

            if(item.getStatusEnum().equals(statusEnum)) {
                Item especificItem = (Item ) getItemByType(clazz, item);
                if(especificItem != null){
                    listItem.add(especificItem);
                }

            }
        }
        return listItem;

    }

    public <T> T getItemByType(Class<T> clazz, Item item){
        T itemByType = null;

        if(item.getClass().equals(clazz)){
            itemByType = (T) item;
        }
        return itemByType;
    }

}