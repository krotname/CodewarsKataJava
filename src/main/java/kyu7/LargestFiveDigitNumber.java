package kyu7;


import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class LargestFiveDigitNumber {

    //7 https://www.codewars.com/kata/51675d17e0c1bed195000001/train/java

    private static final int SEQUENCE = 5;

    public static int solve(final String digits) {
        int max = 0;

        String[] split = digits.split("");

        for (int i = 0; i < split.length - 4; i++) {
            int current;
            StringBuilder currentSB = new StringBuilder();
            for (int j = 0; j < SEQUENCE; j++) {
                currentSB.append(split[i + j]);
            }
            current = Integer.parseInt(currentSB.toString());

            max = Math.max(current, max);
        }

        return max;
    }

    public static int solveStream(final String digits) {
        return IntStream.range(0, digits.length() - 4)
                .mapToObj(i -> digits.substring(i, i + 5))
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0);
    }

    public static int maxValueFrom5Dig(final String digits) {
        return Integer.parseInt(Stream.of(digits.split(""))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .map(String::valueOf)
                .collect(Collectors.joining("")));
    }

}
