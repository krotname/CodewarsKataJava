package kyu7;


import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Accumul {

    //7

    /**
     * This time no story, no theory. The examples below show you how to write function accum:
     * <p>
     * Examples:
     * accum("abcd") -> "A-Bb-Ccc-Dddd"
     * accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
     * accum("cwAt") -> "C-Ww-Aaa-Tttt"
     * The parameter of accum is a string which includes only letters from a..z and A..Z.
     */


    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    result.append(String.valueOf(s.charAt(i)).toUpperCase());
                } else {
                    result.append(String.valueOf(s.charAt(i)).toLowerCase());
                }
            }
            result.append("-");
        }

        return result.substring(0, result.length() - 1);
    }

    public static String streamAccum(String s) {
        return s == null || s.isEmpty() ? "" :
                IntStream.range(0, s.length())
                        .mapToObj(i -> Character.toUpperCase(s.charAt(i)) +
                                String.valueOf(Character.toLowerCase(s.charAt(i))).repeat(i))
                        .collect(Collectors.joining("-"));
    }


}
