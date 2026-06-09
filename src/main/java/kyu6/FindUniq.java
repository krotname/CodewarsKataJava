package kyu6;


public class FindUniq {

    //7 https://www.codewars.com/kata/585d7d5adb20cf33cb000235/train/java

    public static double findUniq(double[] arr) {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException("array must contain at least three numbers");
        }

        double repeatedValue = repeatedValue(arr);
        for (double value : arr) {
            if (Double.compare(value, repeatedValue) != 0) {
                return value;
            }
        }
        throw new IllegalArgumentException("array does not contain a unique value");
    }

    private static double repeatedValue(double[] arr) {
        if (Double.compare(arr[0], arr[1]) == 0 || Double.compare(arr[0], arr[2]) == 0) {
            return arr[0];
        }
        return arr[1];
    }

}
