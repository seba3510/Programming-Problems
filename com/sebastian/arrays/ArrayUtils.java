package com.sebastian.arrays;

/**
 * ArrayUtils
 */
public class ArrayUtils {

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
     * @throws EmptyArrayException
     *                             If the given array is empty
     */
    public int findMax(int[] arr) {

        int n = arr.length;

        if ((n == 0)) {

            throw new EmptyArrayException("Cannot find maximum for an empty array");

        }

        else if ((n == 1)) {

            return arr[0];

        }

        else {

            return findMax(arr, 0);
        }

    }// findMax()

    /**
     * Recursive helper function to find the maximum value for an array
     * 
     * @param arr
     *            The given array
     * @param i
     *            Keeps track of the value at the given index of the array
     * @return
     *         The maximum value of the given array
     */
    private int findMax(int[] arr, int i) {

        if ((i == arr.length)) {

            return 0;
        }

        int max = (int) Math.max(arr[i], findMax(arr, i + 1));

        return max;
    }// findMax()

}// class