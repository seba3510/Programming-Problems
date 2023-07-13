package com.sebastian.arrays;

import java.util.Stack;

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
     * Helper method to find the maximum value in the array
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

        // push items of array into the stack
        for (int i = 0; i < n; i++) {

            temp.push(arr[i]);

        } // for loop

        // holds the elements in reverse order
        int[] rev = new int[n];

        // push the elements of the stack into the new array
        for (int i = 0; i < n; i++) {

            rev[i] = temp.pop();

        } // for loop

        arr = rev;

        return arr;
    }// reverse()

    public boolean isPresent(int[] arr, int key) {

        int pos = search(arr, key);

        return (pos != -1);

    }// isPresent()

    public int search(int[] arr, int key) {

        int hi = arr.length - 1;
        int lo = 0;
        return search(arr, key, lo, hi);

    }// search()

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