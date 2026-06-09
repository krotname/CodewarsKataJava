package kyu6;


import java.util.Arrays;
import java.util.Comparator;


public class HighestScoringWord {

    //6 https://www.codewars.com/HighestScoringWord/57eb8fcdf670e99d9b000272/train/java

    private static final int ASCII_INT = 96;

    public static String high(String s) {
        return Arrays.stream(s.split("\\s"))
                .max(Comparator.comparingInt(word -> word.chars()
                        .map(c -> Character.toLowerCase(c) - ASCII_INT)
                        .sum()))
                .orElseThrow();
    }


}
