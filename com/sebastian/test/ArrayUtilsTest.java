package com.sebastian.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sebastian.arrays.ArrayUtils;

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

}// class