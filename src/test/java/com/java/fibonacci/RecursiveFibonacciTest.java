package com.java.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RecursiveFibonacciTest {

    @InjectMocks
    RecursiveFibonacci recursiveFibonacci;

    @Test
    public void recursiveFibTest() {
        assertEquals(1, recursiveFibonacci.computeFib(1));
        assertEquals(1, recursiveFibonacci.computeFib(1));
        assertEquals(2, recursiveFibonacci.computeFib(3));
        assertEquals(832040, recursiveFibonacci.computeFib(30));
    }

    @Test
    public void recursiveFibIllegalArgumentTest() {
        boolean caught = false;
        try {
            recursiveFibonacci.computeFib(-1);
        } catch (IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);
    }
}