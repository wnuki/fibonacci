package com.java.fibonacci;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Scanner;

@Component
public class Time {

    FastFibonacci fastFibonacci = new FastFibonacci();
    RecursiveFibonacci recursiveFibonacci = new RecursiveFibonacci();
    IterativeFibonacci iterativeFibonacci = new IterativeFibonacci();

    @SuppressWarnings("Duplicates")
    public void countTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n ");
        long n = scanner.nextLong();

        System.out.println("------Recursive Fibonacci-----");
        long beginTimeRec = System.currentTimeMillis();
        long fibRec = recursiveFibonacci.computeFib(n);
        long endTimeRec = System.currentTimeMillis();
        long timeRec = endTimeRec - beginTimeRec;
        System.out.println("F(" + n + ") = " + fibRec + " / computed in " + timeRec + " ms\n");

        System.out.println("------Iterative Fibonacci-----");
        long beginTimeIter = System.currentTimeMillis();
        BigInteger fibIter = iterativeFibonacci.computeFib(n);
        long endTimeIter = System.currentTimeMillis();
        long timeIter = endTimeIter - beginTimeIter;
        System.out.println("F(" + n + ") = " + fibIter + " / computed in " + timeIter + " ms\n");

        System.out.println("------Fast Fibonacci-----");
        long beginTimeFast = System.currentTimeMillis();
        BigInteger fibFast = fastFibonacci.computeFib(n);
        long endTimeFast = System.currentTimeMillis();
        long timeFast = endTimeFast - beginTimeFast;
        System.out.println("F(" + n + ") = " + fibFast + " / computed in " + timeFast + " ms");

    }
}
