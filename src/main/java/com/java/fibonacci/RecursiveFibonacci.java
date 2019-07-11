package com.java.fibonacci;

import org.springframework.stereotype.Component;

@Component
public class RecursiveFibonacci {

    public long computeFib(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n have to be >= 0!");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        if (n > 45) {
            System.out.println("Don't try to compute recursively for n > 45. It's not worth.");
            return -1;
        }
        return computeFib(n - 1) + computeFib(n - 2);
    }
}
