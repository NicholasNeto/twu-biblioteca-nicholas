package com.twu.biblioteca.util.test;


import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.util.Utilitaria;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;


public class UtilitarioTest {

    ArrayList<User> usersList;
    ArrayList<Item> mediasMovieAndBookList;

    Utilitaria utilitarioTest = new Utilitaria();

    @Test
    public void  shouldHaveTheSizeDesiredListUser() {

        assertNull(usersList);
        int desiredSizeAfterCallingMethod = 4;
        usersList = utilitarioTest.createListUserAndPassword();
        assertEquals(desiredSizeAfterCallingMethod, usersList.size());
    }

    @Test
    public void shouldHaveAttributesOfUser(){

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

    @Test
    public void shouldHaveTheSizeDesiredListItens(){

        assertNull(mediasMovieAndBookList);
        int desiredSizeAfterCallingMethod = 8;
        mediasMovieAndBookList = utilitarioTest.createItemsList();
        assertEquals(desiredSizeAfterCallingMethod, mediasMovieAndBookList.size());
    }

    @Test
    public void shouldHaveTwoTypesOfDifferentItemsInList(){

        mediasMovieAndBookList = utilitarioTest.createItemsList();
        assertTrue(mediasMovieAndBookList.get(0) instanceof Book);
        assertTrue(mediasMovieAndBookList.get(5) instanceof Movie);
    }

    @Test
    public void shouldHaveAttributesOItens(){

        mediasMovieAndBookList = utilitarioTest.createItemsList();
        assertEquals("1",  mediasMovieAndBookList.get(0).getId());
        assertEquals("TDD",  mediasMovieAndBookList.get(0).getName());
        assertEquals(2000,  mediasMovieAndBookList.get(0).getYears());
    }

}
