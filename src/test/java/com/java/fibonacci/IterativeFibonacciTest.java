package com.java.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IterativeFibonacciTest {

    @InjectMocks
    IterativeFibonacci iterativeFibonacci;

    @Test
    public void iterativeFibTest() throws InterruptedException {
        assertEquals(BigInteger.ONE, iterativeFibonacci.computeFib(1));
        assertEquals(BigInteger.ONE, iterativeFibonacci.computeFib(1));
        assertEquals(BigInteger.valueOf(2), iterativeFibonacci.computeFib(3));
        assertEquals(BigInteger.valueOf(832040), iterativeFibonacci.computeFib(30));
    }

    @Test
    public void recursiveFibIllegalArgumentTest() throws InterruptedException {
        boolean caught = false;
        try {
            iterativeFibonacci.computeFib(-1);
        } catch (IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);
    }
}