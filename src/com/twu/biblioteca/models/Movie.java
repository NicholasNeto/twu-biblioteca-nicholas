package com.twu.biblioteca.models;

public class Movie extends Item {
    public String director;
    public int rate;



    public Movie(String id, String name, String director, int years, int rate ) {
        super(id, name, years);
        this.director = director;
        this.setStatusEnum(StatusEnum.AVAILABLE);
    }

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
        String possessorName;
        if (this.possessor != null) {
            possessorName = this.possessor.getName();
        } else {
            possessorName = "Free";
        }
        return String.format("%20s %20s %20s %20d %20s", this.getId(), this.getName(), this.getDirector(), this.getYears(), this.getStatusEnum());
    }

    @Override
    public boolean equals(Object obj) {

        Movie movie = (Movie) obj;

        if (movie.getId().equals(this.getId())
                && movie.getName().equals(this.getName())
                && movie.getDirector().equals(this.getDirector())
                && movie.getYears() == getYears())
        {
            return true;
        }
            return false;

    }
}