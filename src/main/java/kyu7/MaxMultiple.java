package kyu7;


import java.util.stream.IntStream;


public class MaxMultiple {

    //7 https://www.codewars.com/kata/5aba780a6a176b029800041c/train/java

    public static int maxMultiple(int divisor, int bound) {
        return IntStream.iterate(bound, i -> i - 1)
                .limit(bound)
                .filter(n -> n % divisor == 0)
                .findFirst()
                .orElse(0);
    }
}
