package kyu7;



public class NbYear {

    //7 https://www.codewars.com/kata/563b662a59afc2b5120000c6/train/java

    public static int nbYear(int p0, double percent, int aug, int p) {
        int year = 0;
        while (p0 < p) {
            p0 = (int) (p0 + (p0 * (percent / 100) + aug));
            year++;
        }
        return year;
    }


}
