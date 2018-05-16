package com.twu.biblioteca.services;

import com.twu.biblioteca.models.Item;

import java.util.ArrayList;

public class TableFormatting {

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

}
