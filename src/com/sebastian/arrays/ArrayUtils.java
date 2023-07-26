package com.sebastian.arrays;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * This class contains utility methods for arrays
 * 
 * @author
 *         Sebastian L. Corporan Berrios
 *         date: 07/13/2023
 */
public class ArrayUtils {

    /**
     * Default constructor
     */
    public ArrayUtils() {
    }

    /**
     * Returns the maximum value in the array
     * 
     * @param arr
     *            The given array
     * @return
     *         {@link ArrayUtils#findMax(int[], int)}
     * 
     * 
     */
    public int findMax(int[] arr) {

        int n = arr.length;

        if ((n == 0)) {

            return 0; // array is empty
        }

        return findMax(arr, 0);
    }// findMax()

    /**
     * Recursively finds the maximum value in the array
     * 
     * @param arr
     *            The given array
     * @param i
     *            Keeps track of the indexes of the values in the array
     * @return
     *         The largest value in the array
     */
    private int findMax(int[] arr, int i) {

        int n = arr.length;

        if ((i == n - 1)) {

            return arr[i];
        }

        int max = Math.max(arr[i], findMax(arr, i + 1));

        return max;

    }// findMax()

    /**
     * Returns the size of the given array
     * 
     * @param arr
     *            The given array
     * @return
     *         The length of the array
     */
    private int size(int[] arr) {

        return arr.length;
    }// size()

    /**
     * Determines whether the given array is empty
     * 
     * @param arr
     *            The given array
     * @return
     * 
     *         {@code true} if the array is empty, {@code false} otherwise
     */
    private boolean isEmpty(int[] arr) {

        return (size(arr) == 0);
    }// isEmpty()

    /**
     * Reverses the order of the elements of the given array
     * 
     * @param arr
     *            The array to reverse
     * @return
     *         The modified array with its elements in reversed order
     */
    public int[] reverse(int[] arr) {

        int n = arr.length;

        if ((isEmpty(arr))) {
            throw new EmptyArrayException("Cannot reverse an empty array");
        }

        Stack<Integer> temp = new Stack<>();

        pushItems(temp, arr);

        // holds the elements in reverse order
        int[] rev = new int[n];

        // push the elements of the stack into the new array
        for (int i = 0; i < n; i++) {

            rev[i] = temp.pop();

        } // for loop

        arr = rev;

        return arr;
    }// reverse()

    /**
     * Pushes the elements of the array into the stack
     * 
     * @param temp
     *             The stack to store the elements of the array
     * @param arr
     *             The given array to store its elements in the stack
     */
    private void pushItems(Stack<Integer> temp, int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {

            temp.push(arr[i]);

        } // for loop

    }// fill()

    /**
     * Checks whether the given element is present in the array
     * 
     * @param arr
     *            The given array to check
     * @param key
     *            The value to check its presence in the array
     * @return
     * 
     *         {@code true} if the element is present, {@code false} otherwise
     */
    public boolean isPresent(int[] arr, int key) {

        int pos = search(arr, key);

        return (pos != -1);

    }// isPresent()

    /**
     * Searches for the given element using the binary search algorithm
     * 
     * @param arr
     *            The given array
     * @param key
     *            The key of the element to search
     * @return
     *         {@link ArrayUtils#search(int[], int, int, int)}
     */
    public int search(int[] arr, int key) {

        int hi = arr.length - 1;
        int lo = 0;
        return search(arr, key, lo, hi);

    }// search()

    /**
     * Recursive helper method that searches for the given element using the binary
     * search algorithm
     * 
     * @param arr
     *            The given array
     * @param key
     *            The key of the element to search
     * 
     * @param lo
     *            The left-most element to in the array
     * @param hi
     *            The right-most element in the array
     * @return
     *         The position of the element if found, {@code -1} otherwise
     */
    private int search(int[] arr, int key, int lo, int hi) {

        if ((lo <= hi)) {

            int mid = (lo + hi) / 2;

            if ((key == arr[mid])) {

                return mid;

            }

            else if ((key < arr[mid])) {

                return search(arr, key, lo, mid - 1);

            }

            else {

                return search(arr, key, mid + 1, hi);
            }

        } // if()

        return -1;
    }// search()

    /**
     * Returns a list containing the elements of odd positions in the array
     * 
     * @param arr
     *            The given array
     * @return
     *         A list containing the elements in odd positions
     */
    public List<Integer> oddPositions(int[] arr) {

        int n = arr.length;

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {

            if ((i % 2 != 0)) {
                result.add(arr[i]);
            }
        } // for loop

        return result;

    }// oddPositions()

    public int[] digits(int num) {

        // get the number of digits to determine size of array that contains the digits
        int n = numDigits(num);

        int[] digits = new int[n];

        int i = 0;

        // extract each digit from the number to store them in new list
        while ((num > 0)) {

            // store current last digit in list
            int temp = num % 10;
            digits[i++] = temp;

            // extract current last digit from list
            num = num / 10;

        } // while loop

        /**
         * Temporary stack to hold the digits
         * 
         * NOTE: This stack was created due to the fact that when testing this function
         * the digits where stored from right to left instead of the left to right
         */
        Stack<Integer> st = new Stack<Integer>();

        pushItems(st, digits);

        // create a new list to hold the result
        int[] result = new int[digits.length];

        // pop each element from the stack to the new list
        for (int idx = 0; idx < result.length; idx++) {

            result[idx] = st.pop();

        } // for loop

        return result;

    }// digits()

    /**
     * Returns the number of digits that the given number contains
     * 
     * @param num
     *            The given number
     * @return
     *         The number of digits that the given number contains
     */
    private int numDigits(int num) {

        int count = 0;

        // extract the digits from the number
        while ((num > 0)) {

            num /= 10; // num = num / 10

            count++;

        } // while loop

        return count;
    }// numDigits()

    /**
     * Sorts the given array using the selection sort algorithm
     * 
     * @param arr
     *            The given array to sort
     */
    public void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {

                if ((arr[j] < arr[minIdx])) {
                    minIdx = j;
                }

            } // for loop

            swap(arr, i, minIdx);

        } // for loop

    }// selectionSort()

    /**
     * Swaps 2 values to sort the array
     * 
     * @param arr
     *            The given array
     * @param i
     *            First index of the array to swap
     * @param j
     *            Second index of the array to swap
     */
    private void swap(int[] arr, int i, int j) {

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }// swap()

    /**
     * Sorts the given array using the bubble sort algorithm
     * 
     * @param arr
     *            The array to sort
     */
    public void bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < (n - i - 1); j++) {

                if ((arr[j] > arr[j + 1])) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                } // if()

            } // for loop
        } // for loop
    }// bubbleSort()

    /**
     * Returns a list containing the first n fibonacci numbers
     * 
     * @param n
     *          The given number
     * @return
     * 
     *         A list containing the first n fibonacci numbers
     */
    public int[] fibonacci(int n) {

        checkNotNegative(n);

        if ((n == 0)) {
            return new int[] { 0 };

        }

        else if ((n == 1)) {

            return new int[] { 0, 1 };
        }

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {

            fib[i] = fib[i - 1] + fib[i - 2];

        } // for loop

        return fib;

    }// fibonacci()

    /**
     * Checks whether the given number is negative
     * 
     * @param n
     *          The number to check
     * 
     * @throws IllegalArgumentException
     *                                  if the number is negative
     */

    private void checkNotNegative(int n) {

        if ((n < 0)) {

            throw new IllegalArgumentException("Negative number: " + n);
        }
    }// checkNotNegative()

    /**
     * Returns a string representation of the given array
     * 
     * @param arr
     *            The array to display
     * @return
     *         The string representation of the array
     */
    public String display(int[] arr) {

        StringBuilder sb = new StringBuilder("[");

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);

            if ((i != n - 1)) {

                sb.append(", ");
            }
        } // for loop

        return sb.append("]").toString();

    }// display()

}// class
