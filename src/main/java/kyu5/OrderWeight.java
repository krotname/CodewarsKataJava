package kyu5;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;


public class OrderWeight {

    //5 https://www.codewars.com/kata/55c6126177c9441a570000cc/train/java

    public static String orderWeight(String string) {
        if (string == null || string.trim().isEmpty()) {
            return "";
        }
        String[] s = string.trim().split("\\s+"); // Изменено на "\\s+"
        Arrays.sort(s, new WeightComparator());
        return String.join(" ", s);
    }

    /**
     * My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month a list with
     * the weights of members is published and each month he is the last on the list which means he is the heaviest.
     * <p>
     * I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list".
     * It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.
     * <p>
     * For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.
     * <p>
     * Given a string with the weights of FFC members in normal order can you give this string ordered by "weights" of these numbers?
     * <p>
     * Example:
     * "56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
     * <p>
     * "100 180 90 56 65 74 68 86 99"
     * When two numbers have the same "weight", let us class them as if they were strings (alphabetical ordering) and not numbers:
     * <p>
     * 180 is before 90 since, having the same "weight" (9), it comes before as a string.
     * <p>
     * All numbers in the list are positive numbers and the list can be empty.
     * <p>
     * Notes
     * it may happen that the input string have leading, trailing whitespaces and more than a unique whitespace
     * between two consecutive numbers
     * For C: The result is freed.
     */



    private static class WeightComparator implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 1L;

        public static int weight(String string) {
            int r = 0;
            for (char c : string.toCharArray()) {
                r += c - '0';
            }
            return r;
        }

        @Override
        public int compare(String s, String t1) {
            int weightDifference = Integer.compare(weight(s), weight(t1));
            if (weightDifference != 0) {
                return weightDifference;
            }
            return s.compareTo(t1);
        }
    }
}
