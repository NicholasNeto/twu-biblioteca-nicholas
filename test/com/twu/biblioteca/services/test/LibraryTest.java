package com.twu.biblioteca.services.test;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;
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
    private User user;


    @Before
    public void setUp() {
        user = new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1313");
        library = new Library(user);
//        library.setUser(user);
        bookList = new ArrayList<Book>();
        movieList = new ArrayList<Movie>();

        bookTdd = new Book("1", "TDD", "Kent", 2005);
        bookList.add(bookTdd);
        //library.setBookList(bookList);

        movieList.add(new Movie("1", "The Matrix", "Nick", 2015));
        //library.setFilmList(movieList);
    }

    @Test
    public void shuldLendABookWithSuccessful() {

        String borrowMessage = library.borrowLibraryMedia("1");

        assertEquals("Thank you! Enjoy the book", borrowMessage);
    }

    @Test
    public void shouldNotLendABook() {

        library.borrowLibraryMedia("1");
        assertEquals("This book is not available", library.borrowLibraryMedia("3"));
    }

    @Test
    public void shouldReturnBookWithSuccessful() {

        library.borrowLibraryMedia("1");
        assertEquals("Thank you for returning the book", library.returMediaToTheLibrary("1"));
    }

    @Test
    public void shouldNotReturnBook() {

        library.borrowLibraryMedia("1");
        library.returMediaToTheLibrary("1");

        assertEquals("This is not a valid book to return", library.returMediaToTheLibrary("3"));
        //assertTrue(library.bookList.contains(bookTdd));
    }

    @Test
    public void shuldLendAMovieWithSuccessful() {

        String borrowMessage = library.borrowLibraryMedia("1");

        assertEquals("Thank you! Enjoy the film", borrowMessage);
    }

    @Test
    public void shouldNotLendAMovie() {

        library.borrowLibraryMedia("1");
        assertEquals("This film is not available", library.borrowLibraryMedia("2"));
    }

    @Test
    public void shouldReturnMovieWithSuccessful() {

        library.borrowLibraryMedia("1");
        assertEquals("Thank you for returning the film", library.borrowLibraryMedia("1"));
    }

    @Test
    public void shouldNotReturnMovie() {

        library.borrowLibraryMedia("1");
        library.returMediaToTheLibrary("1");

        assertEquals("This is not a valid film to return", library.returMediaToTheLibrary("2"));
    }

    @Test
    public void shouldShowManyBooks() {
        ArrayList<Book> _bookList = new ArrayList<Book>();

        _bookList.add(new Book("1", "TDD", "Kent", 2005));
        _bookList.add(new Book("2", "Design Patterns", "Fowler", 2004));
        //library.setBookList(_bookList);

        assertEquals(String.format("%20s %20s %20s %20d %20s\n%20s %20s %20s %20d %20s", "1",
                "TDD", "Kent", 2005, "Free", "2", "Design Patterns", "Fowler", 2004, "Free"), library.getMediasAsString(_bookList));
    }

    @Test
    public void shouldShowATableOfBooks() {

        assertEquals(String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "1", "TDD", "Kent", 2005, "Free"), library.showMediaInTable(bookList));
    }

    @Test
    public void shouldShowATableOfMovies() {

        assertEquals(String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "1", "The Matrix", "Nick", 2015, "Free"), library.showMediaInTable(movieList));
    }

    @Test
    public void shouldSeeBooksUnavailable() {

        String expectBooksUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "1", "TDD", "Kent", 2005, "Nicholas");

        library.borrowLibraryMedia("1");
//        assertEquals(expectBooksUnavailableList, library.showUnavailableBook());
    }

    @Test
    public void shouldSeeMoviesUnavailable() {

        String expectMoviesUnavailableList = String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name", "Authors", "Years", "Status", "1", "The Matrix", "Nick", 2015, "Nicholas");

        library.borrowLibraryMedia("1");
//        assertEquals(expectMoviesUnavailableList, library.showUnavailableFilm());
    }


    @Test
    public void shouldNotHaveAnyPeopleLogged() {

//        assertFalse(library.isLogged());
    }

    @Test
    public void shouldLoginInLibraryWithSuccessful() {

//        library.login("1", "1313");
//        assertTrue(library.isLogged());
    }

}
