package kyu7;


import java.util.List;


public class BinaryArrayToNumber {
    //7 https://www.codewars.com/kata/578553c3a1b8d5c40300037c

    public static int convertBinaryArrayToInt(List<Integer> binary) {
        if (binary == null) {
            throw new IllegalArgumentException("binary digits must not be null");
        }

        int result = 0;
        for (Integer digit : binary) {
            if (digit == null || digit < 0 || digit > 1) {
                throw new IllegalArgumentException("binary digits must be 0 or 1");
            }
            result = result * 2 + digit;
        }
        return result;
    }

}
