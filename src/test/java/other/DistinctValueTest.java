package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class DistinctValueTest {

    @Test
    void shouldKeepFirstOccurrenceOrder() {
        List<String> values = List.of("java", "kata", "java", "code", "kata");

        assertEquals(List.of("java", "kata", "code"), DistinctValue.find(values));
        assertEquals(List.of("java", "kata", "code"), DistinctValue.findOptimal(values));
    }

    @Test
    void shouldHandleNullsAndEmptyInputs() {
        assertEquals(List.of(), DistinctValue.find(null));
        assertEquals(List.of(), DistinctValue.find(List.of()));
        assertEquals(Arrays.asList("a", null, "b"), DistinctValue.find(Arrays.asList("a", null, "b", null)));
    }
}
