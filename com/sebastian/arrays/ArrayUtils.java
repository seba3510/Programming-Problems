package com.sebastian.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

        if ((i == arr.length - 1)) {

            return arr[i];
        }

        int max = Math.max(arr[i], findMax(arr, i + 1));

        return max;

    }// findMax()

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

        if ((n == 0)) {
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
     *            The value to check if present in the array
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

            if ((i % 2 == 0)) {
                result.add(arr[i]);
            }
        } // for loop

        return result;

    }// oddPositions()

    /**
     * Returns a list containing the first n fibonacci numbers
     * 
     * @param n
     *          The number to calculate its fibonacci sequence
     * @return
     *         A list containing the first n fibonacci numbers
     * 
     * @throws IllegalArgumentException
     *                                  If the given number is negative
     */
    public int fib(int n) {

        checkNotNegative(n);

        int[] fib = new int[n + 2];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {

            fib[i] = fib[i - 1] + fib[i - 2];
        } // for loop

        return fib[n];

    }// fib()

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