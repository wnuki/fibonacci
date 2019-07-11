package com.java.fibonacci;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class IterativeFibonacci {

    public BigInteger computeFib(long n) {

        if (n < 0) {
            throw new IllegalArgumentException("n have to be >= 0!");
        }
        if (n == 0 || n == 1) {
            return BigInteger.valueOf(n);
        }
        BigInteger fib = BigInteger.ONE;
        BigInteger prevFib = BigInteger.ONE;

        for (long i = 2; i < n; i++) {
            BigInteger temp = fib;
            fib = fib.add(prevFib);
            prevFib = temp;
        }
        return fib;
    }
}
