package other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class CompareTest {

    @Test
    void naturalOrderingShouldSortByAThenB() {
        List<Compare.Compar> values = new ArrayList<>(List.of(
                value(2, 1),
                value(1, 3),
                value(1, 2)
        ));

        values.sort(null);

        assertEquals(List.of(value(1, 2), value(1, 3), value(2, 1)), values);
    }

    @Test
    void customComparatorShouldSortByBThenA() {
        List<Compare.Compar> values = new ArrayList<>(List.of(
                value(3, 2),
                value(2, 1),
                value(1, 1)
        ));

        values.sort(Compare.ComparComparator.builder().build());

        assertEquals(List.of(value(1, 1), value(2, 1), value(3, 2)), values);
    }

    @Test
    void comparatorShouldRemainSerializable() {
        assertInstanceOf(Serializable.class, Compare.ComparComparator.builder().build());
    }

    private static Compare.Compar value(int a, int b) {
        return Compare.Compar.builder()
                .a(a)
                .b(b)
                .build();
    }
}
