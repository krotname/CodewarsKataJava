package algorithms.sprint0;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algorithms.sprint0.Utils.printList;
import static algorithms.sprint0.Utils.readList;
import static org.junit.jupiter.api.Assertions.*;

public class Zip {

    private static List<Integer> zip(List<Integer> a, List<Integer> b, int n) {
        if (n < 0) throw new IllegalArgumentException("n >= 0 required");
        int min = Math.min(n, Math.min(a.size(), b.size()));
        ArrayList<Integer> integers = new ArrayList<>(min * 2);

        for (int i = 0; i < min; i++) {
            integers.add(a.get(i));
            integers.add(b.get(i));
        }
        return integers;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            List<Integer> a = readList(reader);
            List<Integer> b = readList(reader);
            printList(zip(a, b, n), writer);
        }
    }

    @Test
    void equalLength_nEqualsSize() {
        List<Integer> a = Arrays.asList(1, 3, 5);
        List<Integer> b = Arrays.asList(2, 4, 6);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), zip(a, b, 3));
    }

    @Test
    void nSmallerThanSizes() {
        List<Integer> a = Arrays.asList(10, 30, 50);
        List<Integer> b = Arrays.asList(20, 40, 60);
        assertEquals(Arrays.asList(10, 20, 30, 40), zip(a, b, 2));
    }

    @Test
    void nZero_returnsEmpty() {
        List<Integer> a = Arrays.asList(1, 3, 5);
        List<Integer> b = Arrays.asList(2, 4, 6);
        assertTrue(zip(a, b, 0).isEmpty());
    }

    @Test
    void nGreaterThanSizes_clampedToMin() {
        List<Integer> a = Arrays.asList(1, 3, 5);
        List<Integer> b = Arrays.asList(2, 4, 6);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), zip(a, b, 10));
    }

    @Test
    void oneListShorter_minByShorter() {
        List<Integer> a = List.of(1);
        List<Integer> b = Arrays.asList(2, 4, 6);
        assertEquals(Arrays.asList(1, 2), zip(a, b, 3));
    }

    @Test
    void emptyLists_anyN_returnsEmpty() {
        List<Integer> a = List.of();
        List<Integer> b = List.of();
        assertTrue(zip(a, b, 5).isEmpty());
    }

    @Test
    void negativeN_throwsIAE_withMessage() {
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class,
                        () -> zip(List.of(1), List.of(2), -1));
        assertTrue(ex.getMessage().contains("n >= 0"));
    }

    @Test
    void nullA_throwsNPE() {
        assertThrows(NullPointerException.class, () -> zip(null, List.of(2), 1));
    }

    @Test
    void nullB_throwsNPE() {
        assertThrows(NullPointerException.class, () -> zip(List.of(1), null, 1));
    }
}
