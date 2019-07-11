package com.java.fibonacci.service;

import com.java.fibonacci.model.OperationModel;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@EnableAspectJAutoProxy
public class FastFibonacci {

    public BigInteger computeFib(OperationModel model) {
        return computeFib(model.getN());
    }
    
    private  BigInteger computeFib(long n) {
        BigInteger[] matrix = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};
        return matrixPow(matrix, n)[1];
    }

    private BigInteger[] matrixPow(BigInteger[] matrix, long n) {
        if (n < 0)
            throw new IllegalArgumentException();
        BigInteger[] result = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE};
        while (n != 0) {
            if (n % 2 != 0)
                result = matrixMultiply(result, matrix);
            n /= 2;
            matrix = matrixMultiply(matrix, matrix);
        }
        return result;
    }

    private BigInteger[] matrixMultiply(BigInteger[] x, BigInteger[] y) {
        return new BigInteger[] {
                multiply(x[0], y[0]).add(multiply(x[1], y[2])),
                multiply(x[0], y[1]).add(multiply(x[1], y[3])),
                multiply(x[2], y[0]).add(multiply(x[3], y[2])),
                multiply(x[2], y[1]).add(multiply(x[3], y[3]))
        };
    }

    private BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }
}
