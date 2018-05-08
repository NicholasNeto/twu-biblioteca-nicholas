package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    Library library;
    List<Book> bookList;
    List<Movie> filmList;

    @Before
    public void setUp(){
        library = new Library();
        bookList = new ArrayList<Book>();
        filmList = new ArrayList<Movie>();
    }

    @Test
    public void testCreateBookList(){

        library.createBookList();
        assertEquals(4, library.bookList.size());
    }

    @Test
    public void testCreateFilmList(){
        library.createBookList();
        assertEquals(4, library.bookList.size());
    }

    @Test
    public void testCreateListBooks() {
        Book book1 = new Book("1", "TDD", "Kent", 2000);
        Book book2 = new Book("2", "Design Patterns", "Fowler", 2001);
        Book book3 = new Book("3", "Harry Potter", "Kent", 2002);
        Book book4 = new Book("4", "he Lord of the Rings", "Peter Jackson", 2003);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        assertTrue(bookList.contains(book1));
    }

    @Test
    public void testCreateListFilm() {
        Movie film1 = new Movie("1", "A luz", "Nicholas", 2015, 8);
        Movie film2 = new Movie("2", "Mochila Azul", "Nicols", 2014, 5);
        Movie film3 = new Movie("1", "A luz", "Nicholas", 2015, 4);
        Movie film4 = new Movie("2", "Mochila Azul", "Nicols", 2014,6);
        filmList.add(film1);
        filmList.add(film2);
        filmList.add(film3);
        filmList.add(film4);
        assertTrue(filmList.contains(film1));
    }

    @Test
    public void testShowManyBooks(){
        bookList.add(new Book("1","TDD","Kent", 2005));
        bookList.add(new Book("2","Design Patterns","Fowler", 2004));
        library.setBookList(bookList);

        assertEquals(String.format("%20s %20s %20s %20d %20s\n%20s %20s %20s %20d %20s", "1",
                "TDD", "Kent", 2005, "Free", "2", "Design Patterns", "Fowler", 2004, "Free"), library.getMediasAsString(bookList));
    }

    @Test
    public void testGivenBookListShowMediaTable(){
        bookList.add(new Book("1","TDD","Kent", 2005));
        library.setBookList(bookList);
        assertEquals(String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name","Authors", "Years","Status", "1", "TDD", "Kent", 2005, "Free"), library.showMediaInTable(bookList));
    }

    @Test
    public void testGivenFilmListShowMediaTable(){
        filmList.add(new Movie("1", "The Matrix", "Nick", 2015, 3));
        library.setFilmList(filmList);
        assertEquals(String.format("%20s %20s %20s %20s %20s\n%20s %20s %20s %20d %20s",
                "ID", "Name","Authors", "Years", "Status", "1", "The Matrix", "Nick", 2015, "Free"), library.showMediaInTable(filmList));
    }

    @Test
    public void testSucessfulBorrowBook(){
        Book book = new Book("1", "TDD", "Kent", 2005);

        bookList.add(book);
        library.setBookList(bookList);
        String borrowMessage = library.borrowLibraryBook("1");

        assertEquals("Thank you! Enjoy the book", borrowMessage);
    }

    @Test
    public void testUnsuccessfulBorrowBook(){
        Book book = new Book("1", "TDD", "Kent", 2005);

        bookList.add(book);
        library.setBookList(bookList);
        library.borrowLibraryBook("1");

        assertEquals("This book is not available", library.borrowLibraryBook("2"));
    }

    @Test
    public void testSuccessfulReturnBook(){
        Book book = new Book("1", "TDD", "Kent", 2005);

        bookList.add(book);
        library.setBookList(bookList);
        library.borrowLibraryBook("1");

        assertEquals("Thank you for returning the book", library.returnBookToTheLibrary("1"));
    }

    @Test
    public void testUnsuccessfulReturnBook(){

        Book book = new Book("1", "TDD", "Kent", 2005);

        bookList.add(book);
        library.setBookList(bookList);
        library.borrowLibraryBook("1");
        library.returnBookToTheLibrary("1");

        assertEquals("This is not a valid book to return", library.returnBookToTheLibrary("2"));
        assertTrue(library.bookList.contains(book));
    }

    @Test
    public void testSucessfulBorrowFilm(){
        Movie film = new Movie("1", "TDD", "Kent", 2005);

        filmList.add(film);
        library.setFilmList(filmList);
        String borrowMessage = library.borrowLibraryFilm("1");

        assertEquals("Thank you! Enjoy the film", borrowMessage);
    }

    @Test
    public void testUnsuccessfulBorrowFilm(){
        Movie film = new Movie("1", "TDD", "Kent", 2005);

        filmList.add(film);
        library.setFilmList(filmList);
        library.borrowLibraryFilm("1");

        assertEquals("This film is not available", library.borrowLibraryFilm("2"));
    }

    @Test
    public void testSuccessfulReturnFilm(){
        Movie film = new Movie("1", "TDD", "Kent", 2005);

        filmList.add(film);
        library.setFilmList(filmList);
        library.borrowLibraryFilm("1");

        assertEquals("Thank you for returning the film", library.returnFilmToTheLibrary("1"));
    }

    @Test
    public void testUnsuccessfulReturnFilm(){
        Movie film = new Movie("1", "TDD", "Kent", 2005);

        filmList.add(film);
        library.setFilmList(filmList);
        library.borrowLibraryFilm("1");
        library.returnFilmToTheLibrary("1");

        assertEquals("This is not a valid film to return", library.returnFilmToTheLibrary("2"));
    }

}
