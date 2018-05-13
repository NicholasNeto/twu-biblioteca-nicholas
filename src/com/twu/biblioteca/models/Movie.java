package com.twu.biblioteca.models;

public class Movie extends Item {
    public String director;
    public int rate;


    public Movie(String id, String name, String director, int years) {
        super(id, name, years);
        this.director = director;
        this.setStatusEnum(StatusEnum.AVAILABLE);
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return String.format("%20s %20s %20s %20d %20s", this.getId(), this.getName(), this.getDirector(), this.getYears(), this.getStatusEnum());
    }

}