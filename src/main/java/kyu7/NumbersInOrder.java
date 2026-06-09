package kyu7;


import java.util.stream.IntStream;


public class NumbersInOrder {
    //7 https://www.codewars.com/kata/56b7f2f3f18876033f000307/train/java

    public static boolean isAscOrder(int[] arr) {
        return IntStream.range(0, arr.length - 1)
                .allMatch(i -> arr[i + 1] >= arr[i]);
    }




}
