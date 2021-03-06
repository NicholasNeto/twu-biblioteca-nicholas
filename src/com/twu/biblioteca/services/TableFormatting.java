package com.twu.biblioteca.services;

import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.util.MessagesUtil;

import java.util.ArrayList;

public class TableFormatting {

    private String tableHeader = String.format("%20s %20s %20s %20s %20s\n", "ID", "Name", "Authors", "Years", "Status");


    public <T extends Item> String showMediaInTable(ArrayList<T> mediaList) {
        return tableHeader + getMediasAsString(mediaList);
    }

    public <T extends Item> String getMediasAsString(ArrayList<T> mediaList) {
        String representation = MessagesUtil.EMPTY_LIST;

        for (Item media : mediaList) {
            representation += media.toString() + "\n";
        }

        return representation;
    }

}
