package other;


import java.util.LinkedHashSet;
import java.util.List;

public class DistinctValue {

    public static <T> List<T> find(List<T> l) {
        if (l == null || l.isEmpty()) {
            return List.of();
        }

        return new LinkedHashSet<>(l).stream().toList();
    }

    public static <T> List<T> findOptimal(List<T> l) {
        return find(l);
    }
}
