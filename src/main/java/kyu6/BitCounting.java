package kyu6;



public class BitCounting {

    //6 https://www.codewars.com/kata/526571aae218b8ee490006f4/train/java

    public static int countBits(int n) {
        return (int) Integer.toBinaryString(n)
                .chars()
                .filter(c -> c == '1')
                .count();
    }


}
