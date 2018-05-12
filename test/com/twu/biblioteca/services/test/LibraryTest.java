package com.twu.biblioteca.services.test;

import com.twu.biblioteca.models.*;
import com.twu.biblioteca.services.Library;
import com.twu.biblioteca.util.Utilitaria;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {


    private Library library;
    private Book bookTdd;

    private User user;
    private Utilitaria util;
    private ArrayList<Item> itemsList;


    @Before
    public void setUp() {


        user = new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1313");
        library = new Library(user);

        itemsList =  library.getItemsList();

        bookTdd = new Book("1", "TDD", "Kent", 2005);
    }

    @Test
    public void shuldLendABookWithSuccessful() {

        String borrowMessage = library.borrowLibraryMedia("1");

        assertEquals("Thank you! Enjoy the book", borrowMessage);
    }

    @Test
    public void shouldNotLendABook() {

        library.borrowLibraryMedia("1");
        assertEquals("That book is not available.", library.borrowLibraryMedia("1"));
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.UNAVAILABLE);
    }

    @Test
    public void shouldReturnBookWithSuccessful() {

        library.borrowLibraryMedia("1");
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.UNAVAILABLE);

        assertEquals("Thank you for returning the book", library.returMediaToTheLibrary("1"));
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.AVAILABLE);

    }

    @Test
    public void shouldNotReturnBook() {

        library.borrowLibraryMedia("1");
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.UNAVAILABLE);

        library.returMediaToTheLibrary("1");
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.AVAILABLE);

        // Try to return a book that has already been returned
        assertEquals("This is not a valid book to return", library.returMediaToTheLibrary("1"));
        assertFalse(itemsList.get(0).getStatusEnum() == StatusEnum.UNAVAILABLE);
    }

    @Test
    public void shuldLendAMovieWithSuccessful() {

        String borrowMessage = library.borrowLibraryMedia("5");
        assertEquals("Thank you! Enjoy the movie", borrowMessage);
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.UNAVAILABLE);
    }

    @Test
    public void shouldNotLendAMovie() {

        library.borrowLibraryMedia("5");
        assertEquals("That movie  is not available.", library.borrowLibraryMedia("5"));
    }

    @Test
    public void shouldReturnMovieWithSuccessful() {

        library.borrowLibraryMedia("5");
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.UNAVAILABLE);

        assertEquals("Thank you for returning the movie", library.returMediaToTheLibrary("5"));
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.AVAILABLE);

    }

    @Test
    public void shouldNotReturnMovie() {

        library.borrowLibraryMedia("5");
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.UNAVAILABLE);

        library.returMediaToTheLibrary("5");
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.AVAILABLE);

        // Try to return a movie that has already been returned
        assertEquals("This is not a valid movie to return", library.returMediaToTheLibrary("5"));
        assertFalse(itemsList.get(4).getStatusEnum() == StatusEnum.UNAVAILABLE);
    }

    @Test
    public void shouldShowManyBooks() {
        ArrayList<Book> _bookList = new ArrayList<Book>();

        _bookList.add(new Book("1", "TDD", "Kent", 2005));
        _bookList.add(new Book("2", "Design Patterns", "Fowler", 2004));
        //library.setBookList(_bookList);

        assertEquals(String.format("%20s %20s %20s %20d %20s\n%20s %20s %20s %20d %20s", "1",
                "TDD", "Kent", 2005, "AVAILABLE", "2", "Design Patterns", "Fowler", 2004, "AVAILABLE"), library.getMediasAsString(_bookList));
    }

    @Test
    public void shouldShowATableOfBooks() {


        ItemsLibrary a = library.getItemLibraryAvaible();

        String listaDesejadaDeBokk =  String.format("%20s %20s %20s %20s %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status",
                "1", "TDD", "Kent", 2000, "AVAILABLE",
                "2" , "Design Patterns" ,"Fowler", 2001,"AVAILABLE",
                "3",  "Harry Potter", "Kent", 2002, "AVAILABLE",
                "4", "The Lord of the Rings", "Peter Jackson", 2003, "AVAILABLE");

        assertEquals( listaDesejadaDeBokk, library.showMediaInTable(a.getBookList()));

    }

    @Test
    public void shouldShowATableOfMovies() {

        ItemsLibrary a = library.getItemLibraryAvaible();

       String listaDesejadaDeMovie =  String.format("%20s %20s %20s %20s %20s\n"
                       + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s\n"
                        + "%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status",
                "5", "A luz", "Nicholas", 2000, "AVAILABLE",
                "6" , "Mochila Azul" ,"Nicols", 2001,"AVAILABLE",
                "7",  "Harry Potter", "J. K. Rowling", 2002, "AVAILABLE",
                "8", "The Matrix", "Cara Incrivel", 2003, "AVAILABLE");


        assertEquals( listaDesejadaDeMovie, library.showMediaInTable(a.getMovieList()));



    }

    @Test
    public void shouldSeeBooksUnavailable() {

        String expectBooksUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "1", "TDD", "Kent", 2000, "UNAVAILABLE");

        library.borrowLibraryMedia("1");
        ItemsLibrary itemsLibrary = library.getItemsUnavailable();

        assertEquals(expectBooksUnavailableList, library.showMediaInTable(itemsLibrary.getBookList()));
    }

    @Test
    public void shouldSeeMoviesUnavailable() {

        String expectMoviesUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "5", "A luz", "Nicholas", 2000, "UNAVAILABLE");

        library.borrowLibraryMedia("5");
        ItemsLibrary itemsLibrary = library.getItemsUnavailable();

        assertEquals(expectMoviesUnavailableList, library.showMediaInTable(itemsLibrary.getMovieList()));
    }

}
