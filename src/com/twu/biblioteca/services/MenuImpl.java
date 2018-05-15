package com.twu.biblioteca.services;



public class MenuImpl implements IMenu{

    @Override
    public String lendBook(Library library, String optionsChosenToBook) {
        return library.borrowLibraryMedia(optionsChosenToBook);
    }

    @Override
    public String lendMovie() {
        return null;
    }

    @Override
    public String returnBook() {
        return null;
    }

    @Override
    public String returnMovie() {
        return null;
    }
}
