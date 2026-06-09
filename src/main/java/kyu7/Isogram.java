package kyu7;


import java.util.HashSet;


public class Isogram {

    //7 https://www.codewars.com/kata/54ba84be607a92aa900000f1/train/java

    public static boolean isIsogram(String str) {
        HashSet<Character> characters = new HashSet<>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (characters.contains(c)) return false;
            characters.add(c);
        }
        return true;
    }

}
