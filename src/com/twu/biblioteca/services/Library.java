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


    public String borrowLibraryMedia(String id) {
        String message = "LOL";

        for(Item item :itemsList) {
            if (item.getId().equals(id)) {
                if (item.getStatusEnum().equals(StatusEnum.AVAILABLE)) {
                    item.setStatusEnum(StatusEnum.UNAVAILABLE);
                    message = MessagesUtil.SUCCESS_MEDIA_BORROWED;
                } else {
                    message = MessagesUtil.FAILURE_MEDIA_BORROWED;
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
                    message = MessagesUtil.FAILED_MEDIA_RETURN;
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