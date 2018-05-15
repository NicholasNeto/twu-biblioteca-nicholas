package com.twu.biblioteca.services;

public interface IMenu {


    String lendBook(Library library, String optionsChosenToBook);
    String lendMovie();
    String returnBook();
    String returnMovie();

}
