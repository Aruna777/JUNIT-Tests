package com.example.Testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private final UserService userService = new UserService();

    @Test
    void getUserByIdTest() throws IllegalAccessException {
        User user = userService.getUserById(1);
        assertAll("User Properties",
                ()-> assertNotNull(user),
                ()-> assertEquals(1, user.getId()),
                ()->assertEquals("John Doe", user.getName()));

    }
}
