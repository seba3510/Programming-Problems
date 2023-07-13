package com.sebastian.arrays;

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
     * @param i
     * @return
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
     *         A new array with the elements in reversed order
     */
    public int[] reverse(int[] arr) {

        int n = arr.length;
        int[] temp = new int[n];

        int i = n - 1;

        while ((i >= 0)) {

            temp[i] = arr[i];
            i--;
        } // while loop
        return temp;
    }// reverse()

    /**
     * Returns a string representation of the given array
     * 
     * @param arr
     *            The array to display
     * @return
     *         A string representation of the array
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