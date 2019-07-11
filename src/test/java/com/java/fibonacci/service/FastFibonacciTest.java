package com.java.fibonacci.service;

import com.java.fibonacci.model.OperationModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FastFibonacciTest {

    @InjectMocks
    FastFibonacci fastFibonacci;

    @Mock
    OperationModel operationModel;

    @Test
    public void testFib1() {
        //Given
        when(operationModel.getN()).thenReturn(1l);

        //When & Then
        assertEquals(BigInteger.ONE, fastFibonacci.computeFib(operationModel));
    }

    @Test
    public void testFib2() {
        //Given
        when(operationModel.getN()).thenReturn(2l);

        //When & Then
        assertEquals(BigInteger.ONE, fastFibonacci.computeFib(operationModel));
    }

    @Test
    public void testFib3() {
        //Given
        when(operationModel.getN()).thenReturn(3l);

        //When & Then
        assertEquals(BigInteger.valueOf(2), fastFibonacci.computeFib(operationModel));
    }

    @Test
    public void testFib30() {
        //Given
        when(operationModel.getN()).thenReturn(30l);

        //When & Then
        assertEquals(BigInteger.valueOf(832040), fastFibonacci.computeFib(operationModel));
    }

    @Test
    public void testFibMinusOne() {
        //Given
        when(operationModel.getN()).thenReturn(-1l);
        boolean caught = false;

        try {
            fastFibonacci.computeFib(operationModel);
        } catch (IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);
    }
}