package com.twu.biblioteca.models.test;

import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest { private Book book;

    private Book bookTdd;

    @Before
    public void setUp(){
        bookTdd = new Book("1","TDD", "Kent", 2005);
    }


    @Test
    public void shouldSeeABookBeingCreatedSuccessfully(){

        assertEquals("TDD", bookTdd.getName());
        assertEquals("Kent", bookTdd.getAuthor());
        assertEquals(2005, bookTdd.getYears());
    }

    @Test
    public void shouldSeeTheAttributesOfABookSuccessfully(){

        String expect = String.format("%20s %20s %20s %20d %20s", "1", "TDD", "Kent", 2005, "Free");
        assertEquals(expect, bookTdd.toString());
    }

}
