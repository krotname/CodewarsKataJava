package other;


import static java.util.Map.Entry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Выводит значение элемента который встречается в списке чаще всего

public class ElementOccursMostOften {

    public static <T> T find(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("list must not be empty");
        }

        Map<T, Integer> counts = new LinkedHashMap<>();
        list.forEach(element -> counts.merge(element, 1, Integer::sum));

        // LinkedHashMap keeps tie-breaking deterministic: the first most-frequent value wins.
        return counts.entrySet().stream()
                .max(Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

}
