package com.example.Testing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PaymentServiceTest {

    @Mock
    private PaymentService paymentService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessPaymentThrowsException(){
        doThrow(new InsufficientFundsException()).when(paymentService).processPayment(gt(1000.0));
        assertThrows(InsufficientFundsException.class, ()->paymentService.processPayment(1500.0));


    }
}
