package com.sebastian.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sebastian.arrays.ArrayUtils;
import com.sebastian.arrays.EmptyArrayException;

public class ArrayUtilsTest {

    private ArrayUtils obj;

    @Before
    public void setUp() {

        obj = new ArrayUtils();
    }

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

}// class