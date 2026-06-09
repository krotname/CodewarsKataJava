package kyu6;



public class StringSplit {

    //6 https://www.codewars.com/kata/515de9ae9dcfc28eb6000001/train/java

    public static String[] solution(String s) {
        if (s == null) {
            throw new IllegalArgumentException("input must not be null");
        }

        String[] result = new String[(s.length() + 1) / 2];
        for (int i = 0; i < result.length; i++) {
            int start = i * 2;
            if (start + 1 < s.length()) {
                result[i] = s.substring(start, start + 2);
            } else {
                result[i] = s.charAt(start) + "_";
            }
        }
        return result;
    }

    /**
     * Complete the solution so that it splits the string into pairs of two characters.
     * If the string contains an odd number of characters then it should replace the missing second
     * character of the final pair with an underscore ('_').
     * <p>
     * Examples:
     * <p>
     * StringSplit.solution("abc") // should return {"ab", "c_"}
     * StringSplit.solution("abcdef") // should return {"ab", "cd", "ef"}
     */


}
