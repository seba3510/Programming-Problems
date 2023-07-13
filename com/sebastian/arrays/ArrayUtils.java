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

            return 0;
        }

        return findMax(arr, 0);
    }// findMax()

    private int findMax(int[] arr, int i) {

        if ((i == arr.length - 1)) {

            return arr[i];
        }

        int max = Math.max(arr[i], findMax(arr, i + 1));

        return max;

    }// findMax()

}// class