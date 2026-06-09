package kyu7;



public class GetSum {

    //7 https://www.codewars.com/kata/55f2b110f61eb01779000053/train/java

    public static int getSum(int a, int b) {
        return (a + b) * (Math.abs(a - b) + 1) / 2;
    }

}
