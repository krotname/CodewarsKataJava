package kyu5;

public class WhoIsNext {

    //6 https://www.codewars.com/kata/551dd1f424b7a4cdae0001f0/train/java

    public static String whoIsNext(String[] names, int n) {
        if (names == null || names.length == 0 || n <= 0) {
            throw new IllegalArgumentException("names must be non-empty and n must be positive");
        }

        long position = n;
        long repetitions = 1L;
        long roundSize = names.length;

        // Each full round doubles how many consecutive copies each name owns.
        // Skipping whole rounds keeps the algorithm logarithmic instead of simulating the queue.
        while (position > roundSize * repetitions) {
            position -= roundSize * repetitions;
            repetitions *= 2L;
        }

        int index = (int) ((position - 1) / repetitions);
        return names[index];
    }

    public static String whoIsNextLinkedList(String[] names, int n) {
        return whoIsNext(names, n);
    }
}
