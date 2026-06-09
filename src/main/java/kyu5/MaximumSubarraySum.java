package kyu5;


import java.util.Arrays;


public class MaximumSubarraySum {

    //5

    public static int sequence(int[] arr) {
        int maximumSubArraySum = arraySum(arr);
        for (int i = 0; i <= arr.length; i++) {
            for (int j = arr.length; j >= i; j--) {
                int[] ints = Arrays.copyOfRange(arr, i, j);
                int subArraySum = arraySum(ints);
                if (subArraySum > maximumSubArraySum) {
                    maximumSubArraySum = subArraySum;
                }
            }
        }
        return maximumSubArraySum;
    }

    private static int arraySum(int[] arr) {
        int result = 0;
        for (int i : arr
        ) {
            result += i;
        }
        return result;
    }

    /**
     * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence
     * in an array or list of integers:
     * <p>
     * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
     * If the list is made up of only negative numbers, return 0 instead.
     * <p>
     * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
     */

}
