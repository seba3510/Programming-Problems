package com.sebastian.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.swing.tree.ExpandVetoException;

import org.junit.Before;
import org.junit.Test;

import com.sebastian.arrays.ArrayUtils;
import com.sebastian.arrays.EmptyArrayException;

public class ArrayUtilsTest {

    /** Instance of {@link ArrayUtils} to be used for testing */
    private ArrayUtils obj;

    @Before
    public void setUp() {

        obj = new ArrayUtils();
    }// setUp()

    @Test
    public void testFindMax() {

        int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        int expected1 = 6;
        int result1 = obj.findMax(arr1);
        assertEquals(expected1, result1);

        int[] arr2 = { -3, -2, -1, -10 };
        int expected2 = -1;
        int result2 = obj.findMax(arr2);
        assertEquals(expected2, result2);

        int[] arr3 = { 11 };
        int expected3 = 11;
        int result3 = obj.findMax(arr3);
        assertEquals(expected3, result3);

        int[] arr4 = {};
        int expected4 = 0;
        int result4 = obj.findMax(arr4);
        assertEquals(expected4, result4);
    }// testFindMax()

    @Test
    public void testDisplay() {

        int[] arr = { 1, 2, 3, 4, 5 };
        String expected = "[1, 2, 3, 4, 5]";
        String result = obj.display(arr);
        assertEquals(expected, result);

    }// testDisplay()

    @Test
    public void testReverse() {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        String expected1 = "[5, 4, 3, 2, 1]";
        int[] result1 = obj.reverse(arr1);
        assertEquals(expected1, obj.display(result1));

        int[] arr2 = { -3, -2, -1, 0, 1, 2 };
        int[] result2 = obj.reverse(arr2);
        String expected2 = "[2, 1, 0, -1, -2, -3]";
        assertEquals(expected2, obj.display(result2));

        int[] arr3 = { 1, 2, 3 };
        int[] result3 = obj.reverse(arr3);
        String expected3 = "[3, 2, 1]";
        assertEquals(expected3, obj.display(result3));

        int[] arr4 = { 1, 2 };
        int[] result4 = obj.reverse(arr4);
        String expected4 = "[2, 1]";
        assertEquals(expected4, obj.display(result4));

        int[] arr5 = { 1 };
        int[] result5 = obj.reverse(arr5);
        String expected5 = "[1]";
        assertEquals(expected5, obj.display(result5));
    }// testReverse()

    @Test
    public void testReverseForEmptyArray() {

        try {

            int[] arr = new int[0];

            obj.reverse(arr);

            fail("Test failed for empty array");

        } catch (EmptyArrayException e) {

            String expected = "Cannot reverse an empty array";
            String result = e.getMessage();
            assertEquals(expected, result);
        } // catch()

    }// testReverseForEmptyArray()

    @Test
    public void testSearch() {

        int[] arr1 = { 1, 2, 3, 4, 5 };
        int expected1 = 2;
        int result1 = obj.search(arr1, 3);
        assertEquals(expected1, result1);

        int result2 = obj.search(arr1, 5);
        int expected2 = 4;
        assertEquals(expected2, result2);

        int result3 = obj.search(arr1, 10);
        int expected3 = -1;
        assertEquals(expected3, result3);

    }// testSearch()

    @Test
    public void testisPresent() {

        int[] arr1 = { 1, 2, 3, 4, 5 };
        assertTrue(obj.isPresent(arr1, 2));

        int[] arr2 = { -3, -2, -1, 0, 1, 2 };
        assertFalse(obj.isPresent(arr2, 6));

        int[] arr3 = new int[0];
        assertFalse(obj.isPresent(arr3, 8));

    }// testisPresent()

    @Test
    public void testOddPositions() {

        int[] arr1 = { 1, 2, 3, 4, 5 };
        String expected1 = "[1, 3, 5]";
        List<Integer> result1 = obj.oddPositions(arr1);
        assertEquals(expected1, result1.toString());

        int[] arr2 = {};
        String expected2 = "[]";
        List<Integer> result2 = obj.oddPositions(arr2);
        assertEquals(expected2, result2.toString());

    }// testOddPositions()

    @Test
    public void testFibonacci() {

        // Test case 1: n = 0
        int expected1 = 0;
        int result1 = obj.fib(0);
        assertEquals(expected1, result1);

        // Test case 2: n = 1
        int expected2 = 1;
        int result2 = obj.fib(1);
        assertEquals(expected2, result2);

        // Test case 3: n = 5
        int expected3 = 5;
        int result3 = obj.fib(5);
        assertEquals(expected3, result3);

        // Test case 4: n = 10
        int expected4 = 55;
        int result4 = obj.fib(10);
        assertEquals(expected4, result4);

        // Test case 5: n = 15
        int expected5 = 610;
        int result5 = obj.fib(15);
        assertEquals(expected5, result5);

    }// testFibonacci()

    @Test
    public void testFibonacciForNegative() {

        try {
            obj.fib(-9);

            fail("Test failed for negative number");
        } catch (IllegalArgumentException e) {

            String expected = "Negative number: -9";
            String result = e.getMessage();
            assertEquals(result, expected);
        } // catch()

    }// testFibonacciForNegative()

}
// class