package kyu7;


import java.util.Arrays;
import java.util.List;


public class Troll {
    //6

    /**
     * Trolls are attacking your comment section!
     * <p>
     * A common way to deal with this situation is to remove all of the vowels from the trolls' comments,
     * neutralizing the threat.
     * <p>
     * Your task is to write a function that takes a string and return a new string with all vowels removed.
     * <p>
     * For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
     * <p>
     * Note: for this kata y isn't considered a vowel
     */

    private static final Character[] VOWEL = {'a', 'e', 'i', 'o', 'u'};
    private static final List<Character> VOWEL_LIST = Arrays.asList(VOWEL);

    public static String disembowel(String s) {

        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()
        ) {
            if (!VOWEL_LIST.contains(Character.toLowerCase(c))) {
                result.append(c);
            }
        }
        return result.toString();
    }

}
