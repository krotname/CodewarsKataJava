package kyu6;



public class toCamelCase {

    //6 https://www.codewars.com/kata/517abf86da9663f1d2000003/train/java

    public static String toCamelCase(String s) {
        if (s == null || s.isEmpty()) return "";
        String[] split = s.split("[-_]");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(split[0]);
        for (int i = 1; i < split.length; i++) {
            stringBuilder.append(split[i].substring(0, 1).toUpperCase()).append(split[i].substring(1));
        }
        return stringBuilder.toString();
    }

    /**
     * Complete the method/function so that it converts dash/underscore delimited words into camel casing.
     * The first word within the output should be capitalized only if the original word was capitalized
     * (known as Upper Camel Case, also often referred to as Pascal case).
     */

}
