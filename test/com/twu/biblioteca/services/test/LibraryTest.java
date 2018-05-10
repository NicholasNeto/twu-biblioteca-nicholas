package com.twu.biblioteca.services.test;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.services.Library;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private Book bookTdd;


    @Before
    public void setUp(){

        library = new Library();
        bookList = new ArrayList<Book>();
        movieList = new ArrayList<Movie>();

        bookTdd = new Book("1", "TDD", "Kent", 2005);
        bookList.add(bookTdd);
        library.setBookList(bookList);

        movieList.add(new Movie("1", "The Matrix", "Nick", 2015));
        library.setFilmList(movieList);
    }
    
    @Test
    public void shuldLendABookWithSuccessful(){

        String borrowMessage = library.borrowLibraryBook("1");

        assertEquals("Thank you! Enjoy the book", borrowMessage);
    }

    @Test
    public void shouldNotLendABook(){

        library.borrowLibraryBook("1");
        assertEquals("This book is not available", library.borrowLibraryBook("3"));
    }

    @Test
    public void shouldReturnBookWithSuccessful(){

        library.borrowLibraryBook("1");
        assertEquals("Thank you for returning the book", library.returnBookToTheLibrary("1"));
    }

    @Test
    public void shouldNotReturnBook (){

        library.borrowLibraryBook("1");
        library.returnBookToTheLibrary("1");

        assertEquals("This is not a valid book to return", library.returnBookToTheLibrary("3"));
        assertTrue(library.bookList.contains(bookTdd));
    }

    @Test
    public void shuldLendAMovieWithSuccessful(){

        String borrowMessage = library.borrowLibraryFilm("1");

        assertEquals("Thank you! Enjoy the film", borrowMessage);
    }

    @Test
    public void shouldNotLendAMovie(){

        library.borrowLibraryFilm("1");
        assertEquals("This film is not available", library.borrowLibraryFilm("2"));
    }

    @Test
    public void shouldReturnMovieWithSuccessful(){

        library.borrowLibraryFilm("1");
        assertEquals("Thank you for returning the film", library.returnFilmToTheLibrary("1"));
    }

    @Test
    public void shouldNotReturnMovie(){

        library.borrowLibraryFilm("1");
        library.returnFilmToTheLibrary("1");

        assertEquals("This is not a valid film to return", library.returnFilmToTheLibrary("2"));
    }

    @Test
    public void shouldShowManyBooks(){
        ArrayList<Book> _bookList = new ArrayList<Book>();

        _bookList.add(new Book("1","TDD","Kent", 2005));
        _bookList.add(new Book("2","Design Patterns","Fowler", 2004));
        library.setBookList(_bookList);

        assertEquals(String.format("%20s %20s %20s %20d %20s\n%20s %20s %20s %20d %20s", "1",
                "TDD", "Kent", 2005, "Free","2", "Design Patterns", "Fowler", 2004, "Free" ), library.getMediasAsString(_bookList));
    }
    
    @Test
    public void shouldShowATableOfBooks(){

        assertEquals(String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name","Authors", "Years", "Status", "1", "TDD", "Kent", 2005, "Free"), library.showMediaInTable(bookList));
    }

    @Test
    public void shouldShowATableOfMovies(){

        assertEquals(String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name","Authors", "Years", "Status", "1", "The Matrix", "Nick", 2015, "Free"), library.showMediaInTable(movieList));
    }

}
