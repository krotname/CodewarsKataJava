package kyu7;



public class MinMax {

    public static int[] minMax(int[] arr) {
        int[] r = new int[2];
        r[0] = Integer.MAX_VALUE;
        r[1] = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j < r[0]) {
                r[0] = j;
            }
            if (j > r[1]) {
                r[1] = j;
            }
        }
        return r;
    }

}
