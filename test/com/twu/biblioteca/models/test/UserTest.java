package com.twu.biblioteca.models.test;


import com.twu.biblioteca.models.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void testCreateUser(){

        User user = new User("1", "Nicholas", "Nicholas@gmail.com", 123456789, "1313");
        assertEquals("1", user.getIdUser());
        assertEquals("Nicholas", user.getName());
        assertEquals("Nicholas@gmail.com", user.getEmail());
        assertEquals(123456789, user.getPhone());
        assertEquals("1313", user.getPassword());
    }
}
