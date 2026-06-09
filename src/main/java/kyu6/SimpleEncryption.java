package kyu6;


import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class SimpleEncryption {

    //6 https://www.codewars.com/SimpleEncryption/57814d79a56c88e3e0000786/train/java

    public static String encrypt(final String text, final int n) {
        if (text == null || text.isEmpty() || n < 1) return text;

        var start = new StringBuilder(text);
        var current = new StringBuilder();
        char[] chars = start.toString().toCharArray();

        for (int j = 1; j < start.length(); j += 2) {
            current.append(chars[j]);
        }
        for (int j = 0; j < start.length(); j += 2) {
            current.append(chars[j]);
        }
        start = new StringBuilder(current);
        return encrypt(start.toString(), n - 1);
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null || encryptedText.isEmpty() || n < 1) return encryptedText;

        var start = new StringBuilder(encryptedText);
        var current = new char[start.length()];
        var encryptedList = IntStream.range(0, encryptedText.length())
                .mapToObj(encryptedText::charAt)
                .collect(Collectors.toCollection(LinkedList::new));

        for (int j = 1; j < start.length(); j += 2) {
            current[j] = encryptedList.pollFirst();
        }
        for (int j = 0; j < start.length(); j += 2) {
            current[j] = current[j] = encryptedList.pollFirst();
        }
        start = new StringBuilder(String.valueOf(current));
        return decrypt(start.toString(), n - 1);
    }



}
