package kyu7;


import java.util.List;


public class ListFiltering {

    //7 https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/train/java

    public static List<Integer> filterList(final List<?> list) {
        return list.stream()
                .filter(Integer.class::isInstance)
                .map(Integer.class::cast)
                .toList();
    }

}
