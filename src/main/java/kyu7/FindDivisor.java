package kyu7;


import java.util.stream.IntStream;


public class FindDivisor {

    //7 https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/train/java

    public static long numberOFindDivisorivisors(int i) {
        return IntStream.range(1, i + 1)
                .filter(n -> i % n == 0)
                .count();
    }

}
