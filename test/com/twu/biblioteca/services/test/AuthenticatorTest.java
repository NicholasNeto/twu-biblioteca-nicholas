package com.twu.biblioteca.services.test;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.services.Authenticator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class AuthenticatorTest {

    private User userNicholas, desiredUserNichoals ;
    Authenticator authentic;


    @Before
    public void setUp(){
         authentic = new Authenticator();
         authentic.login("1", "1");
         userNicholas = authentic.getUser();
         desiredUserNichoals = new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1");
    };


    @Test
    public void shouldCouldLoginWithSuccessful(){

         authentic.login("1", "1");
        assertTrue(userNicholas.isLogged());
    }

    @Test
    public void shouldReallyBeTheInformedUser(){

        authentic.login("1", "1");

        assertEquals(desiredUserNichoals.getIdUser(), userNicholas.getIdUser());
        assertEquals(desiredUserNichoals.getName(), userNicholas.getName());
        assertEquals(desiredUserNichoals.getEmail(), userNicholas.getEmail());
        assertEquals(desiredUserNichoals.getPhone(), userNicholas.getPhone());
        assertEquals(desiredUserNichoals.getPassword(), userNicholas.getPassword());
    }
}
