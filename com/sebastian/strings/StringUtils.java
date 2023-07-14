package com.sebastian.strings;

public class StringUtils {

    public StringUtils() {

    }

    /**
     * Checks if the given string is a palindrome
     * 
     * @param str
     *            The string to check
     * 
     * @return
     *         {@code true} if the string is a palindrome , {@code false} otherwise
     */
    public boolean isPalindrome(String str) {

        // first we reverse the string
        String rev = reverse(str);

        return (str.equals(rev));

    }// isPalindrome()

    public String reverse(String str) {

        String rev = "";

        int n = str.length();

        for (int i = n - 1; i >= 0; i--) {

            rev += str.charAt(i);

        } // for loop
        str = rev;

        return str;
    }// reverse()

}// class
