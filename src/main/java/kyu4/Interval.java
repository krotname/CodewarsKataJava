package kyu4;


import java.util.Arrays;
import java.util.Comparator;


public class Interval {

    //4 https://www.codewars.com/kata/52b7ed099cdc285c300001cd/train/java

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[][] sortedIntervals = Arrays.stream(intervals)
                .peek(Interval::validateInterval)
                .map(int[]::clone)
                .sorted(Comparator.comparingInt(interval -> interval[0]))
                .toArray(int[][]::new);

        int coveredLength = 0;
        int currentStart = sortedIntervals[0][0];
        int currentEnd = sortedIntervals[0][1];
        for (int i = 1; i < sortedIntervals.length; i++) {
            int[] interval = sortedIntervals[i];
            if (interval[0] <= currentEnd) {
                currentEnd = Math.max(currentEnd, interval[1]);
            } else {
                coveredLength += currentEnd - currentStart;
                currentStart = interval[0];
                currentEnd = interval[1];
            }
        }
        return coveredLength + currentEnd - currentStart;
    }

    private static void validateInterval(int[] interval) {
        if (interval == null || interval.length != 2 || interval[0] > interval[1]) {
            throw new IllegalArgumentException("interval must contain start <= end");
        }
    }

    /**
     * Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of
     * all the interval lengths. Overlapping intervals should only be counted once.
     * <p>
     * Intervals
     * Intervals are represented by a pair of integers in the form of an array. The first value of the interval will
     * always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
     * <p>
     * Overlapping Intervals
     * List containing overlapping intervals:
     * <p>
     * [
     * [1,4],
     * [7, 10],
     * [3, 5]
     * ]
     * The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval
     * as [1, 5], which has a length of 4.
     * <p>
     * Examples:
     * // null argument
     * Interval.sumIntervals(null);  // => 0
     * <p>
     * // empty intervals
     * Interval.sumIntervals(new int[][]{});  // => 0
     * Interval.sumIntervals(new int[][]{2,2}, {5,5});  // => 0
     * <p>
     * // disjoined intervals
     * Interval.sumIntervals(new int[][]{
     * {1,2},{3,5}
     * });  // => (2-1) + (5-3) = 3
     * <p>
     * // overlapping intervals
     * Interval.sumIntervals(new int[][]{
     * {1,4},{3,6},{2,8}
     * });  // [1,8] => 7
     */


}
