package com.sebastian.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sebastian.strings.StringUtils;

public class StringUtilsTest {

    private StringUtils obj;

    @Before
    public void setUp() {

        obj = new StringUtils();
    }// setUp()

    @Test
    public void testReverseString() {
        String str1 = "luis";
        String expected1 = "siul";
        String result1 = obj.reverse(str1);
        assertEquals(expected1, result1);

        String str2 = "kayak";
        String expected2 = "kayak";
        String result2 = obj.reverse(str2);
        assertEquals(expected2, result2);

        String str3 = "";
        String expected3 = "";
        String result3 = obj.reverse(str3);
        assertEquals(expected3, result3);

    }// testReverseString()

}// class
