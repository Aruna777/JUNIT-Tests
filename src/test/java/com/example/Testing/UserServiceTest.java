package com.example.Testing;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGetById(){
        User mockUser = new User(1, "John Doe");
        when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));
        Optional<User> result = userService.getUserById(1);
        assertEquals(Optional.of(mockUser), result);
        verify(userRepository, times(1)).findById(1);

    }

}
