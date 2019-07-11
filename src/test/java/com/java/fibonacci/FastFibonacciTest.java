package com.java.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FastFibonacciTest {

    @InjectMocks
    FastFibonacci fastFibonacci;

    @Test
    public void recursiveFibTest() {
        assertEquals(1, fastFibonacci.computeFib(1));
        assertEquals(1, fastFibonacci.computeFib(1));
        assertEquals(2, fastFibonacci.computeFib(3));
        assertEquals(832040, fastFibonacci.computeFib(30));
    }

    @Test
    public void recursiveFibIllegalArgumentTest() {
        boolean caught = false;
        try {
            fastFibonacci.computeFib(-1);
        } catch (IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);
    }
}