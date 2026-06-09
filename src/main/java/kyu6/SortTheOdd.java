package kyu6;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class SortTheOdd {

    // 6 https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/train/java

    public static int[] sortArray(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();

        for (int i = 0; i < array.length; i += 2) {
            odd.add(array[i]);
        }

        Collections.sort(odd);

        for (int i = 0; i < array.length; i += 2) {
            array[i] = odd.get((int) (i / 2.0 + 0.5));
        }
        return array;
    }

    public static int[] sortArrayStream(int[] array) {
        LinkedList<Integer> oddSorted = IntStream
                .range(0, array.length)
                .filter(x -> x % 2 == 0)
                .map(x -> array[x])
                .sorted()
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        IntStream.range(0, array.length).forEach(
                x -> {
                    if (x % 2 == 0) {
                        array[x] = oddSorted.pollFirst();
                    }
                });

        return array;
    }


}
