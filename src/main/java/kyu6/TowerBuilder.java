package kyu6;




public class TowerBuilder {

    //6 https://www.codewars.com/kata/576757b1df89ecf5bd00073b/train/java

    public static String[] towerBuilder(int nFloors) {
        String[] strings = new String[nFloors];
        for (int i = 1; i <= nFloors; i++) {
            String string = " ".repeat(nFloors - i) +
                    "*".repeat(i * 2 - 1) +
                    " ".repeat(nFloors - i);
            strings[i - 1] = string;
        }
        return strings;
    }



    public String show() {
        StringBuilder sb = new StringBuilder();
        for (String s : towerBuilder(9)) {
            sb.append(s).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
