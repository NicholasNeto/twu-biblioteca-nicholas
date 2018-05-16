package com.twu.biblioteca.services.test;

import com.twu.biblioteca.models.*;
import com.twu.biblioteca.services.Library;
import com.twu.biblioteca.util.MessagesUtil;
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
        library = new Library();

        itemsList =  library.getItemsList();

        bookTdd = new Book("1", "TDD", "Kent", 2005);
    }

    @Test
    public void shuldLendABookWithSuccessful() {

        String expect = MessagesUtil.SUCCESS_MEDIA_BORROWED;

        String borrowMessage = library.borrowLibraryMedia("1");
        assertEquals(expect, borrowMessage);
    }

    @Test
    public void shouldNotLendABook() {

        String expect = MessagesUtil.FAILURE_MEDIA_BORROWED;

        library.borrowLibraryMedia("1");
        assertEquals(expect, library.borrowLibraryMedia("1"));
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.UNAVAILABLE);
    }

    @Test
    public void shouldReturnBookWithSuccessful() {


        String expect = MessagesUtil.RETURN_MEDIA_SUCCESSFULLY;

        library.borrowLibraryMedia("1");
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.UNAVAILABLE);

        assertEquals(expect, library.returnMediaToTheLibrary("1"));
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.AVAILABLE);

    }

    @Test
    public void shouldNotReturnBook() {


        String expect = MessagesUtil.FAILED_MEDIA_RETURN;

        library.borrowLibraryMedia("1");
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.UNAVAILABLE);

        library.returnMediaToTheLibrary("1");
        assertTrue(itemsList.get(0).getStatusEnum() == StatusEnum.AVAILABLE);

        // Try to return a book that has already been returned
        assertEquals(expect, library.returnMediaToTheLibrary("1"));
        assertFalse(itemsList.get(0).getStatusEnum() == StatusEnum.UNAVAILABLE);
    }

    @Test
    public void shuldLendAMovieWithSuccessful() {

        String expect = MessagesUtil.SUCCESS_MEDIA_BORROWED;

        String borrowMessage = library.borrowLibraryMedia("5");
        assertEquals(expect, borrowMessage);
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.UNAVAILABLE);
    }

    @Test
    public void shouldNotLendAMovie() {

        String expect = MessagesUtil.FAILURE_MEDIA_BORROWED;

        library.borrowLibraryMedia("5");
        assertEquals(expect, library.borrowLibraryMedia("5"));
    }

    @Test
    public void shouldReturnMovieWithSuccessful() {

        library.borrowLibraryMedia("5");
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.UNAVAILABLE);

        assertEquals(MessagesUtil.RETURN_MEDIA_SUCCESSFULLY + MessagesUtil.MOVIE_LABEL, library.returnMediaToTheLibrary("5") + MessagesUtil.MOVIE_LABEL);
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.AVAILABLE);

    }

    @Test
    public void shouldNotReturnMovie() {

        String expect = MessagesUtil.FAILED_MEDIA_RETURN;


        library.borrowLibraryMedia("5");
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.UNAVAILABLE);

        library.returnMediaToTheLibrary("5");
        assertTrue(itemsList.get(4).getStatusEnum() == StatusEnum.AVAILABLE);

        // Try to return a movie that has already been returned
        assertEquals(expect , library.returnMediaToTheLibrary("5"));
        assertFalse(itemsList.get(4).getStatusEnum() == StatusEnum.UNAVAILABLE);
    }

    @Test
    public void shouldShowManyBooks() {
        ArrayList<Book> _bookList = new ArrayList<Book>();

        _bookList.add(new Book("1", "TDD", "Kent", 2005));
        _bookList.add(new Book("2", "Design Patterns", "Fowler", 2004));

        assertEquals(String.format("%20s %20s %20s %20d %20s\n%20s %20s %20s %20d %20s", "1",
                "TDD", "Kent", 2005, "AVAILABLE", "2", "Design Patterns", "Fowler", 2004, "AVAILABLE"), library.getMediasAsString(_bookList));
    }

    @Test
    public void shouldShowATableOfBooks() {


        ArrayList<Item> listItemAvailable  = library.getItemsByStatus(StatusEnum.AVAILABLE, Book.class);

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

        assertEquals( listaDesejadaDeBokk, library.showMediaInTable(listItemAvailable));

    }

    @Test
    public void shouldShowATableOfMovies() {

        ArrayList<Item> listItemAvailable = library.getItemsByStatus(StatusEnum.AVAILABLE, Movie.class);

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


        assertEquals( listaDesejadaDeMovie, library.showMediaInTable((ArrayList<? extends Item>) listItemAvailable));



    }

    @Test
    public void shouldSeeBooksUnavailable() {

        String expectBooksUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "1", "TDD", "Kent", 2000, "UNAVAILABLE");

        library.borrowLibraryMedia("1");
        ArrayList<Item> listItemUnavailable = library.getItemsByStatus(StatusEnum.UNAVAILABLE, Book.class);

        assertEquals(expectBooksUnavailableList, library.showMediaInTable(listItemUnavailable));
    }

    @Test
    public void shouldSeeMoviesUnavailable() {

        String expectMoviesUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "5", "A luz", "Nicholas", 2000, "UNAVAILABLE");

        library.borrowLibraryMedia("5");
        ArrayList<Item> listItemUnavailable = library.getItemsByStatus(StatusEnum.UNAVAILABLE, Movie.class);

        assertEquals(expectMoviesUnavailableList, library.showMediaInTable(listItemUnavailable));
    }

}
