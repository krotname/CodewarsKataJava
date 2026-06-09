package other;

import java.util.Arrays;


public class Anagrams {

    public static int check(String string1, String string2) {
        if (string1 == null || string2 == null) {
            return 0;
        }

        char[] first = string1.trim().toCharArray();
        char[] second = string2.trim().toCharArray();
        if (first.length != second.length) {
            return 0;
        }
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second) ? 1 : 0;
    }

}
