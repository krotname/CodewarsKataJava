package kyu7;


import java.util.TreeSet;


public class TwoToOne {

    //7 https://www.codewars.com/kata/5656b6906de340bd1b0000ac/train/java

    public static String longest(String s1, String s2) {
        TreeSet<Character> characters = new TreeSet<>();
        for (char c : s1.toCharArray()) {
            characters.add(c);
        }
        for (char c : s2.toCharArray()) {
            characters.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character);
        }
        return sb.toString();
    }

}
