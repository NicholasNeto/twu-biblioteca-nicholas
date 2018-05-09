package com.twu.biblioteca.util.test;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.util.Utilitaria;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class UtilitarioTest {

    ArrayList<Book> bookList ;
    List<Movie> filmList;


    Utilitaria utilitarioTest = new Utilitaria();

    @Test
    public void checkListSize(){
        assertNull(bookList);

        int desiredSizeAfterCallingMethod = 4;
        bookList = utilitarioTest.createBookList();
        assertEquals(desiredSizeAfterCallingMethod, bookList.size());
    }

    @Test
    public void checkListAttributesToBook(){
        bookList = utilitarioTest.createBookList();

        assertEquals("1",  bookList.get(0).getId());
        assertEquals("TDD",  bookList.get(0).getName());
        assertEquals("Kent",  bookList.get(0).getAuthor());
        assertEquals(2000,  bookList.get(0).getYears());
    }

    //TODO: Perguntar para o Biharck sobre como comparar duas listas
     @Test
    public void qualquerNome () {

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


}
