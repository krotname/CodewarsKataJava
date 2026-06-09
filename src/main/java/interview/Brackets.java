package interview;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;


public class Brackets {

    /**
     * Дана произвольная строка, в которой могут встречаться разные виды скобок “()[]{}“ в произвольном порядке. Нужно проверить согласованность скобок
     */


    public static boolean check(String string) {
        if (string == null) {
            return false;
        }

        Deque<Character> bracket = new ArrayDeque<>();
        Map<Character, Character> bracketsMap = Map.of(')', '(', ']', '[', '}', '{');

        char[] chars = string.toCharArray();

        for (char aChar : chars) {
            if (bracketsMap.containsValue(aChar)) {
                bracket.add(aChar);
            }

            if (bracketsMap.containsKey(aChar)) {
                Character character = bracket.peekLast();
                if (character == null || !character.equals(bracketsMap.get(aChar))) {
                    return false;
                }
                bracket.removeLast();
            }
        }
        return bracket.isEmpty();
    }
}
