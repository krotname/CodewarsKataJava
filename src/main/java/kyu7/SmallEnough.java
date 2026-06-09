package kyu7;


import java.util.Arrays;


public class SmallEnough {
    //7 https://www.codewars.com/kata/57cc981a58da9e302a000214/train/java

    public static boolean smallEnough(int[] a, int limit) {
        return Arrays.stream(a).allMatch(n -> n <= limit);
    }

}
