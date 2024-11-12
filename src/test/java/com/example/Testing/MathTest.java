package com.example.Testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class MathTest {
    private final MathPrime math = new MathPrime();

    @ParameterizedTest
    @ValueSource(ints = {2, 3,4, 9})
    void MathIsPrimeTest(int number){
        boolean expected = (number ==2 || number ==3);
        assertEquals(expected, math.isPrime(number));
    }

}
