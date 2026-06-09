package algorithms.sprint0;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static algorithms.sprint0.Utils.readInt;
import static algorithms.sprint0.Utils.readList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlidingAverage {

    private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
        int minSize = Math.min(arr.size(), n);
        int count = minSize - windowSize + 1;
        if (windowSize <= 0 || count <= 0) return java.util.Collections.emptyList();
        List<Double> result = new ArrayList<>(count);
        long sum = 0;
        for (int i = 0; i < windowSize; i++) sum += arr.get(i);
        result.add(sum / (double) windowSize);
        for (int i = windowSize; i < minSize; i++) {
            sum += arr.get(i) - arr.get(i - windowSize);
            result.add(sum / (double) windowSize);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int windowSize = readInt(reader);
            List<Double> result = movingAverage(n, arr, windowSize);
            for (double elem : result) {
                writer.write(elem + " ");
            }
        }
    }

    private static void assertListDoubles(List<Double> actual, double... expected) {
        assertEquals(expected.length, actual.size(), "size");
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i), 1e-9, "idx=" + i);
        }
    }

    @Test
    void test1() {
        List<Double> actual = movingAverage(7, List.of(1, 2, 3, 4, 5, 6, 7), 4);
        assertListDoubles(actual, 2.5, 3.5, 4.5, 5.5);
    }

    @Test
    void w1_returnsOriginalValues() {
        List<Double> actual = movingAverage(7, List.of(1, 2, 3, 4, 5, 6, 7), 1);
        assertListDoubles(actual, 1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void wEqMin_singleAverage() {
        List<Double> actual = movingAverage(7, List.of(1, 2, 3, 4, 5, 6, 7), 7);
        assertListDoubles(actual, 4.0);
    }

    @Test
    void wGreaterThanMin_empty() {
        List<Double> actual = movingAverage(5, List.of(1, 2, 3, 4, 5, 6, 7), 6);
        assertEquals(List.of(), actual);
    }

    @Test
    void wZeroOrNegative_empty() {
        assertEquals(List.of(), movingAverage(5, List.of(1, 2, 3, 4, 5), 0));
        assertEquals(List.of(), movingAverage(5, List.of(1, 2, 3, 4, 5), -3));
    }

    @Test
    void cutByN_truncatesAndAverages() {
        List<Double> actual = movingAverage(5, List.of(1, 2, 3, 4, 5, 6, 7), 3);
        // окна по первым 5 элементам: [1,2,3],[2,3,4],[3,4,5]
        assertListDoubles(actual, 2.0, 3.0, 4.0);
    }

    @Test
    void emptyArray_empty() {
        List<Double> actual = movingAverage(10, List.of(), 3);
        assertEquals(List.of(), actual);
    }

    @Test
    void largeValues_noOverflowInSum() {
        int M = Integer.MAX_VALUE;
        List<Double> actual = movingAverage(4, List.of(M, M, M, M), 2);
        // три окна: [M,M],[M,M],[M,M] → среднее = M
        assertListDoubles(actual, M, M, M);
    }
}
