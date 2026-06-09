package interview;


import java.util.Comparator;
import java.util.List;


public class ReverseAndFormat {

    /**
     * Дана последовательность чисел 1,2,3,4,5,6,7,9,10,11. Ее нужно вывести в формате 11,9,7,6,3,1.
     */
    public static List<Integer> reverseAndFormat(List<Integer> integers) {
        List<Integer> result = integers.stream()
                .filter(x -> x % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .map(x -> x.equals(5) ? Integer.valueOf(6) : x)
                .toList();
        return result;
    }

}
