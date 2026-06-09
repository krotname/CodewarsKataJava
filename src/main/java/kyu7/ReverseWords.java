package kyu7;



public class ReverseWords {

    public static String reverseWords(final String original) {
        if (original.matches("\\s+")) return original;
        StringBuilder stringBuilder = new StringBuilder();
        String[] s = original.split("\\s");
        for (String s1 : s
        ) {
            stringBuilder.append(new StringBuilder(s1).reverse()).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

}
