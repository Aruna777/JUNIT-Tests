package com.example.Testing;

public class MathPrime {
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= java.lang.Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
