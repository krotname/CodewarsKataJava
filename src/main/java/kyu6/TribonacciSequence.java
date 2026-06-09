package kyu6;



public class TribonacciSequence {

    //6 https://www.codewars.com/kata/556deca17c58da83c00002db

    public static double[] tribonacci(double[] s, int n) {
        if (n == 0) {
            return new double[0];
        }
        if (n == 1) {
            double[] doubles = new double[1];
            doubles[0] = s[0];
            return doubles;
        }
        if (n == 2) {
            double[] doubles = new double[2];
            doubles[0] = s[0];
            doubles[1] = s[1];
            return doubles;
        }
        double[] doubles = new double[n];

        System.arraycopy(s, 0, doubles, 0, s.length);

        for (int i = s.length; i < n; i++) {
            doubles[i] = doubles[i - 1] + doubles[i - 2] + doubles[i - 3];
        }
        return doubles;
    }

}
