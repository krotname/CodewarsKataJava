package kyu7;


public class RoundToTheNextMultipleOf5 {

    //7 https://www.codewars.com/kata/55d1d6d5955ec6365400006d/train/java

    public static int roundToNext5(int number) {
        int i = number % 5;
        if (number < 0) {
            return number - i;
        } else {
            return i == 0 ? number : number - i + 5;
        }
    }



}
