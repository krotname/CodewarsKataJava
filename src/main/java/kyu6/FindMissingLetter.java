package kyu6;


public class FindMissingLetter {

    //6 https://www.codewars.com/kata/5839edaa6754d6fec10000a2/solutions/java

    public static char findMissingLetter(char[] array) {

        char expected = array[0];
        for (char current : array) {
            if (current != expected) {
                return expected;
            }
            expected++;
        }
        return ' ';
    }


}
