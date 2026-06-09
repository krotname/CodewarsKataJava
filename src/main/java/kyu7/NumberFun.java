package kyu7;



public class NumberFun {

    public static long findNextSquare(long sq) {
        long sqrt = (long) Math.sqrt(sq);
        if (sqrt * sqrt != sq) return -1;
        long next = sqrt + 1;
        return next * next;
    }

}
