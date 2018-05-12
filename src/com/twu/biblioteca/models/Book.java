package com.twu.biblioteca.models;

public class Book extends Item {

    private String author;

    public Book(String id, String name, String author, int years) {
        super(id, name, years);
        this.author = author;
        this.setStatusEnum(StatusEnum.AVAILABLE);
    }

    @Override
    public String toString() {
        return String.format("%20s %20s %20s %20d %20s", this.getId(), this.getName(), author, this.getYears(), this.getStatusEnum());
    }

    public String getAuthor() { return author; }


    @Override
    public boolean equals(Object obj) {

         Book book = (Book) obj;
         if(book.getId().equals( this.getId())
                 && book.getName().equals(this.getName())
                 && book.getAuthor().equals(this.getAuthor())
                 && book.getYears() == getYears())
         {
                return true;
         }
            return false;
    }
}


