package com.example.Testing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StatusServiceTest {
    @Mock
    private StatusService statusService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStatus(){
        when(statusService.getStatus()).thenReturn("ACTIVE").thenReturn("INACTIVE");
        assertEquals("ACTIVE", statusService.getStatus());
        assertEquals("INACTIVE", statusService.getStatus());
    }
}
