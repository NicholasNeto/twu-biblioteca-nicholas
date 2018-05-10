package com.twu.biblioteca.models.test;

import com.twu.biblioteca.models.Movie;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {


    private Movie movieMatrix;

    @Before
    public void setUp(){
        movieMatrix = new Movie("1","The Matrix", "Lilly Wachowski", 2015);
    }

    @Test
    public void shouldSeeAMovieBeingCreatedSuccessfully(){

        assertEquals("The Matrix", movieMatrix.getName());
        assertEquals("Lilly Wachowski", movieMatrix.director);
        assertEquals(2015, movieMatrix.getYears());
    }


    @Test
    public void shouldSeeTheAttributesOfAMovieSuccessfully(){

        String expect = String.format("%20s %20s %20s %20d %20s", "1", "The Matrix", "Lilly Wachowski", 2015, "Free");
        assertEquals(expect, movieMatrix.toString());
    }



}
