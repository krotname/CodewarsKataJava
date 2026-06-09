package kyu7;



public class FindShort {

    //7 https://www.codewars.com/kata/57cebe1dc6fdc20c57000ac9/train/java

    public static int findShort(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String s1 : s.trim().split("\\s+")) {
            min = Math.min(min, s1.length());
        }
        return min;
    }

}
