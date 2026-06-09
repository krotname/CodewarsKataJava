package other;


import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;


// Задача с учебного собеседования на курсе OTUS
// Ищем первый дубликат в массиве чисел

public class OtusInterview {

    public OptionalInt findFirstDuplicate(int[] arr) {

        Set<Integer> uniqueElements = new HashSet<>(arr.length, 1.0f);

        for (int i : arr) {
            if (!uniqueElements.add(i))
                return OptionalInt.of(i);
        }
        return OptionalInt.empty();
    }

    public OptionalInt findFirstDuplicateStream(int[] arr) {
        Set<Integer> uniqueElements = new HashSet<>(arr.length, 1.0f);
        return Arrays.stream(arr).filter(i -> !uniqueElements.add(i)).findAny();
    }





}
