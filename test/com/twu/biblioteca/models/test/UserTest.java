package com.twu.biblioteca.models.test;


import com.twu.biblioteca.models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    User userNicholas;

    @Before
    public void setUp(){
        userNicholas = new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1313");
    }

    @Test
    public void testCreateUser(){

        assertEquals("1", userNicholas.getIdUser());
        assertEquals("Nicholas", userNicholas.getName());
        assertEquals("Nicholas@gmail.com", userNicholas.getEmail());
        assertEquals(123456789, userNicholas.getPhone());
        assertEquals("1313", userNicholas.getPassword());
    }

    @Test
    public void shouldNotBeLoggedIn(){

        assertFalse(userNicholas.isLogged());
    }


    @Test
    public void shouldBeLoggedIn() {

        userNicholas.setLogged(true);
        assertTrue(userNicholas.isLogged());
    }
}
