package com.twu.biblioteca.classes.de.negocio;

import com.twu.biblioteca.classes.de.negocio.Item;

public class Movie extends Item {
    public String director;
    public int rate;

    public Movie(String id, String name, String director, int years, int rate){
        super(id, name, years);
        this.director = director;
    }

    public Movie(String id, String name, String director, int years) {
        super(id, name, years);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        String possessorName;
        if (this.possessor != null){
            possessorName = this.possessor.getName();
        } else{
            possessorName = "Free";
        }
        return String.format("%20s %20s %20s %20d %20s", this.getId(), this.getName(), this.getDirector(),  this.getYears(),  possessorName);
    }
}
