package com.java.fibonacci.service;

import com.java.fibonacci.model.OperationModel;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@EnableAspectJAutoProxy
public class IterativeFibonacci {

    public BigInteger computeFib(OperationModel model) {
        return computeFib(model.getN());
    }

    private BigInteger computeFib(long n) {

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
