package kyu6;


public class FindOdd {

    //6

    public static int findIt(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int result = 0;
        for (int num : a) {
            result ^= num;
        }
        return result;
    }

    /**
     * Given an array of integers, find the one that appears an odd number of times.
     * There will always be only one integer that appears an odd number of times.
     * <p>
     * [7] should return 7, because it occurs 1 time (which is odd).
     * [0] should return 0, because it occurs 1 time (which is odd).
     * [1,1,2] should return 2, because it occurs 1 time (which is odd).
     * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
     * [1,2,2,3,3,3,4,3,3,3,2,2,1] shold return 4, because it appears 1 time (which is odd).
     */


}
