package com.twu.biblioteca.util.test;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.util.Utilitaria;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;


public class UtilitarioTest {

    ArrayList<Book> bookList ;
    ArrayList<Movie> filmList;
    ArrayList<User> usersList;

    Utilitaria utilitarioTest = new Utilitaria();

    @Test
    public void checkListSizeToBook(){

        assertNull(bookList);
        int desiredSizeAfterCallingMethod = 4;
        bookList = utilitarioTest.createBookList();
        assertEquals(desiredSizeAfterCallingMethod, bookList.size());
    }

    @Test
    public void checkListAttributesToBookWithAnyIndex(){

        bookList = utilitarioTest.createBookList();
        assertEquals("1",  bookList.get(0).getId());
        assertEquals("TDD",  bookList.get(0).getName());
        assertEquals("Kent",  bookList.get(0).getAuthor());
        assertEquals(2000,  bookList.get(0).getYears());
    }

     @Test
    public void checkListAttributesToBookWithSomeIndex() {

         ArrayList<Book> books = new ArrayList<Book>();
         books.add(new Book("1", "TDD", "Kent", 2000));
         books.add(new Book("2", "Design Patterns", "Fowler", 2001));
         books.add(new Book("3", "Harry Potter", "Kent", 2002));
         books.add(new Book("4", "The Lord of the Rings", "Peter Jackson", 2003));

         bookList = utilitarioTest.createBookList();
         assertThat(books, CoreMatchers.is(bookList));
    }

    @Test
    public void checkMovieSize(){

        assertNull(filmList);
        int desiredSizeAfterCallingMethod = 4;
        filmList = utilitarioTest.createFilmList();
        assertEquals(desiredSizeAfterCallingMethod, filmList.size());
    }

    @Test
    public void checkListAttributesToMovie(){
        filmList = utilitarioTest.createFilmList();

        assertEquals("1",  filmList.get(0).getId());
        assertEquals("A luz",  filmList.get(0).getName());
        assertEquals("Nicholas",  filmList.get(0).getDirector());
        assertEquals(2000,  filmList.get(0).getYears());

    }

    @Test
    public void checkListAttributesToMovieWithAnyIndex(){

        filmList = utilitarioTest.createFilmList();
        assertEquals("A luz", filmList.get(0).getName());
        assertEquals("Nicholas", filmList.get(0).director);
        assertEquals(2000, filmList.get(0).getYears());
    }

    @Test
    public void checkListAttributesToMovieWithSomeIndex() {

        ArrayList<Movie> movies = new ArrayList<Movie>();

        movies.add(new Movie("1", "A luz", "Nicholas", 2000));
        movies.add(new Movie("2", "Mochila Azul", "Nicols", 2001));
        movies.add(new Movie("3", "Harry Potter", "J. K. Rowling", 2002));
        movies.add(new Movie("4", "The Matrix", "Cara Incrivel", 2003));

        filmList = utilitarioTest.createFilmList();
        assertThat(movies, CoreMatchers.is(filmList));
    }



    @Test
    public void checkListSizeToUser() {

        assertNull(usersList);
        int desiredSizeAfterCallingMethod = 4;
        usersList = utilitarioTest.createListUserAndPassword();
        assertEquals(desiredSizeAfterCallingMethod, usersList.size());
    }

    @Test
    public void checkListAttributesToUser(){

        usersList = utilitarioTest.createListUserAndPassword();

        assertEquals("1", usersList.get(0).getIdUser());
        assertEquals("Nicholas", usersList.get(0).getName());
        assertEquals("Nicholas@gmail.com", usersList.get(0).getEmail());
        assertEquals(123456789, usersList.get(0).getPhone());
        assertEquals("1313", usersList.get(0).getPassword());
    }

    @Test
    public void checkListAttributesToUserWithAnyIndex(){

        usersList = utilitarioTest.createListUserAndPassword();

        assertEquals("1", usersList.get(0).getIdUser());
        assertEquals("Nicholas", usersList.get(0).getName());
        assertEquals("Nicholas@gmail.com", usersList.get(0).getEmail());
        assertEquals(123456789, usersList.get(0).getPhone());
        assertEquals("1313", usersList.get(0).getPassword());
    }

    @Test
    public void checkListAttributesToUsersWithSomeIndex() {

        ArrayList<User> users = new ArrayList<User>();

        users.add(new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1313"));
        users.add(new User("12", "Thalyta", "Thalyta@gmail.com", 9899999, "12"));
        users.add(new User("123", "Erica", "Erica@gmail.com", 123456789, "123"));
        users.add(new User("1234", "Katia", "Katia@gmail.com", 123456789, "1234"));

        usersList = utilitarioTest.createListUserAndPassword();
        assertThat(users, CoreMatchers.is(usersList));
    }



}
