package other;


import java.util.List;


public class RecursionMax {

    public static int recursionMax(List<Integer> array) {
        if (array == null) {
            return -1;
        }
        if (array.isEmpty()) {
            return -1;
        }
        return recursionMax(array, 0, Integer.MIN_VALUE);
    }

    private static int recursionMax(List<Integer> array, int index, int currentMax) {
        if (index == array.size()) {
            return currentMax;
        }
        return recursionMax(array, index + 1, Math.max(currentMax, array.get(index)));
    }

    public static int max(List<Integer> array) {
        if (array == null) {
            return -1;
        }
        if (array.isEmpty()) {
            return -1;
        }
        if (array.size() == 1) {
            return array.get(0);
        }
        int max = Integer.MIN_VALUE;
        for (int a : array
        ) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }


}
