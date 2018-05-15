package com.twu.biblioteca.models;

public abstract class Item {


    private String id;
    private String name;
    private int year;
    private StatusEnum statusEnum;

    Item (String id, String name, int year){
        this.id = id;
        this.name = name;
        this.year = year;

    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public int getYears() { return year; }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}
