package kyu6;


import java.util.Arrays;
import java.util.HashMap;


public class EnoughIsEnough {

    //6 https://www.codewars.com/kata/554ca54ffa7d91b236000023

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        HashMap<Integer, Integer> count = new HashMap<>();
        return Arrays.stream(elements).filter(i -> {
            count.computeIfPresent(i, (key, value) -> ++value);
            count.putIfAbsent(i, 1);
            return count.get(i) <= maxOccurrences;
        }).toArray();
    }

}
