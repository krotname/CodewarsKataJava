package kyu7;


import java.util.ArrayList;
import java.util.List;


public class LineNumbering {

    //7 https://www.codewars.com/kata/54bf85e3d5b56c7a05000cf9/train/java

    public static List<String> number(List<String> lines) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            arrayList.add(i + 1 + ": " + lines.get(i));
        }
        return arrayList;
    }

}
