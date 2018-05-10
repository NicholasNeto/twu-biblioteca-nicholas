package com.twu.biblioteca.models;

import com.twu.biblioteca.models.StatusEnum;

public abstract class Item {


    private String id;
    private String name;
    private int years;
    private StatusEnum statusEnum;
    User possessor;

    Item (String id, String name, int years){
        this.id = id;
        this.name = name;
        this.years = years;

    }

    boolean available = true;

    public boolean isAvailable(){
        return available;
    }

    public void lendToUser(User possessor){
        this.possessor = possessor;
        this.available = false;
    }

    public void setReturn(){
        this.possessor = null;
        this.available = true;
    }
    public String getId() { return id; }

    public String getName() { return name; }

    public int getYears() { return years; }
}
