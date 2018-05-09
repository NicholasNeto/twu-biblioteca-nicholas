package com.twu.biblioteca.models.test;

import com.twu.biblioteca.models.Movie;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testCreateBook(){
        Movie film1 = new Movie("1","The Matrix", "Cara Incrivel", 2015);
        assertEquals("The Matrix", film1.getName());
        assertEquals("Cara Incrivel", film1.director);
        assertEquals(2015, film1.getYears());
    }

}
