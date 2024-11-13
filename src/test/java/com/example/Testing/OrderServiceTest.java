package com.example.Testing;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderService orderService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrder(){
        orderService.placeOrder("Phone", 1);
        verify(orderService).placeOrder(anyString(), gt(0));
    }

}
