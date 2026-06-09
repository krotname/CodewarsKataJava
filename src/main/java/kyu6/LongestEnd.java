package kyu6;

//6 https://www.codewars.com/kata/56a5d994ac971f1ac500003e/train/java


import java.util.ArrayList;
import java.util.Comparator;


public class LongestEnd {

    public static String longestEnd(String[] strarr, int k) {
        ArrayList<String> strings = new ArrayList<>();
        for (int n = 0; n < strarr.length - k + 1; n++) {
            StringBuilder currentWord = new StringBuilder();
            for (int i = n; i < n + k; i++) {
                currentWord.append(strarr[i]);
            }
            strings.add(currentWord.toString());
        }
        return strings.stream().max(Comparator.comparing(String::length)).orElse("");
    }

}
