package interview;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MaximumSequenceWithOneZero {
    /**
     * Дан массив из 0 и 1. Надо вывести максимальную последовательность 1 в этом массиве, при условии,
     * что она может быть разделена только одним 0. Пример вывода: 1,0,1,1,1,0,0,1,1,1 -> 4.
     */
    public static int maximumSequenceWithOneZero(List<Integer> b) {
        if (Objects.isNull(b) || b.isEmpty()) return 0;
        if (b.size() == 1 && b.get(0) == 1) return 1;
        if (b.size() == 1 && b.get(0) == 0) return 0;

        List<Integer> bytes = new ArrayList<>(b);
        int maxCount = 0;
        int count = 0;
        if (bytes.get(0) == 1) count++;

        for (int i = 1; i < bytes.size(); i++) {
            if (bytes.get(i) == 1 && bytes.get(i - 1) == 1) {
                count++;
            }
            if (bytes.get(i) == 1 && bytes.get(i - 1) == 0) {
                count++;
            }
            if (bytes.get(i) == 0 && bytes.get(i - 1) == 0) {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return Math.max(count, maxCount);
    }




}
