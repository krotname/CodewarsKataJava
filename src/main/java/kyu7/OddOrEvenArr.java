package kyu7;


import java.util.Arrays;


public class OddOrEvenArr {
    //7 https://www.codewars.com/kata/5949481f86420f59480000e7

    public static String oddOrEven(int[] array) {
        return Arrays.stream(array).sum() % 2 != 0 ? "odd" : "even";
    }

}
