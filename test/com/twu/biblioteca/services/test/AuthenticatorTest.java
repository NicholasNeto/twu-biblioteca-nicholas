package com.twu.biblioteca.services.test;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.services.Autheticator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class AuthenticatorTest {

    private User userNicholas, desiredUserNichoals ;
    Autheticator authentic;


    @Before
    public void setUp(){
         authentic = new Autheticator();
         authentic.login("1", "1313");
         userNicholas = authentic.getUser();
         desiredUserNichoals = new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1313");
    };


    @Test
    public void shouldCouldLoginWithSuccessful(){

         authentic.login("1", "1313");
        assertTrue(userNicholas.isLogged());
    }

    @Test
    public void shouldReallyBeTheInformedUser(){

        authentic.login("1", "1313");

        assertEquals(desiredUserNichoals.getIdUser(), userNicholas.getIdUser());
        assertEquals(desiredUserNichoals.getName(), userNicholas.getName());
        assertEquals(desiredUserNichoals.getEmail(), userNicholas.getEmail());
        assertEquals(desiredUserNichoals.getPhone(), userNicholas.getPhone());
        assertEquals(desiredUserNichoals.getPassword(), userNicholas.getPassword());
    }
}
