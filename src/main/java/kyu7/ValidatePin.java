package kyu7;


import java.util.regex.Pattern;


public class ValidatePin {
    // 7 https://www.codewars.com/kata/55f8a9c06c018a0d6e000132/train/java

    public static boolean validatePin(String pin) {
        if (pin == null) {
            return false;
        }
        return Pattern.compile("[\\d]{4}|[\\d]{6}").matcher(pin).matches();
    }



}
