package com.twu.biblioteca.services.test;

import com.twu.biblioteca.models.*;
import com.twu.biblioteca.services.Library;
import com.twu.biblioteca.services.TableFormatting;
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
    TableFormatting  tableFormatting = new TableFormatting();


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

}
