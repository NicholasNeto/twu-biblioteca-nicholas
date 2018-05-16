package com.twu.biblioteca.services.test;

import com.twu.biblioteca.models.*;
import com.twu.biblioteca.services.Library;
import com.twu.biblioteca.services.TableFormatting;
import com.twu.biblioteca.util.Utilitaria;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TableFormattingTest {


    private Library library;
    private Book bookTdd;
    private User user;
    private Utilitaria util;
    private ArrayList<Item> itemsList;
    private TableFormatting tableFormatting = new TableFormatting();

    @Before
    public void setUp() {

        user = new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1");
        library = new Library();

        itemsList =  library.getItemsList();
        bookTdd = new Book("1", "TDD", "Kent", 2005);
    }


    @Test
    public void shouldShowManyBooks() {
        ArrayList<Book> _bookList = new ArrayList<Book>();

        _bookList.add(new Book("1", "TDD", "Kent", 2005));
        _bookList.add(new Book("2", "Design Patterns", "Fowler", 2004));

        assertEquals(String.format("%20s %20s %20s %20d %20s\n%20s %20s %20s %20d %20s", "1",
                "TDD", "Kent", 2005, "AVAILABLE", "2", "Design Patterns", "Fowler", 2004, "AVAILABLE"), tableFormatting.getMediasAsString(_bookList));
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

        assertEquals( listaDesejadaDeBokk, tableFormatting.showMediaInTable(listItemAvailable));

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


        assertEquals( listaDesejadaDeMovie, tableFormatting.showMediaInTable((ArrayList<? extends Item>) listItemAvailable));

    }

    @Test
    public void shouldSeeBooksUnavailable() {

        String expectBooksUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "1", "TDD", "Kent", 2000, "UNAVAILABLE");

        library.borrowLibraryMedia("1");
        ArrayList<Item> listItemUnavailable = library.getItemsByStatus(StatusEnum.UNAVAILABLE, Book.class);

        assertEquals(expectBooksUnavailableList, tableFormatting.showMediaInTable(listItemUnavailable));
    }

    @Test
    public void shouldSeeMoviesUnavailable() {

        String expectMoviesUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "5", "A luz", "Nicholas", 2000, "UNAVAILABLE");

        library.borrowLibraryMedia("5");
        ArrayList<Item> listItemUnavailable = library.getItemsByStatus(StatusEnum.UNAVAILABLE, Movie.class);

        assertEquals(expectMoviesUnavailableList, tableFormatting.showMediaInTable(listItemUnavailable));
    }

}
