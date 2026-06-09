package kyu6;



public class FindOutlier {
    //6

    public static int find(int[] integers) {

        if (integers == null || integers.length < 3) {
            throw new IllegalArgumentException();
        }

        // The first three values are enough to determine which parity is the majority,
        // so the method stays O(n) and avoids counting the full array.
        int paritySum = parity(integers[0]) + parity(integers[1]) + parity(integers[2]);
        int outlierParity = paritySum <= 1 ? 1 : 0;
        for (int integer : integers) {
            if (parity(integer) == outlierParity) {
                return integer;
            }
        }
        return -1;
    }

    private static int parity(int value) {
        return Math.abs(value % 2);
    }

    /**
     * Since we are warned the array may be very large, we should avoid counting values any more than we need to.
     * <p>
     * We only need the first 3 integers to determine whether we are chasing odds or evens.
     * So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
     * It will be 0 for even numbers and 1 for odd numbers.
     * Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
     */


}
