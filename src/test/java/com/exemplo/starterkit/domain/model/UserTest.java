package com.exemplo.starterkit.domain.model;

import com.exemplo.starterkit.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    public void UserTest(){
        User user = new User("Marcos", 12, "Nhamundá", 6998797);
        assertEquals("Marcos", user.getName());
        //assertTrue(user.toString().contains("User{"));
    }
}
