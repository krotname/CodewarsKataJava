package other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class ElementOccursMostOftenTest {

    @Test
    void shouldReturnMostFrequentElement() {
        assertEquals("java", ElementOccursMostOften.find(List.of("java", "kata", "java", "test")));
    }

    @Test
    void shouldUseFirstValueWhenFrequenciesAreEqual() {
        assertEquals("first", ElementOccursMostOften.find(List.of("first", "second")));
    }

    @Test
    void shouldSupportNullElements() {
        assertNull(ElementOccursMostOften.find(java.util.Arrays.asList(null, "value", null)));
    }

    @Test
    void shouldRejectMissingInput() {
        assertThrows(IllegalArgumentException.class, () -> ElementOccursMostOften.find(null));
        assertThrows(IllegalArgumentException.class, () -> ElementOccursMostOften.find(List.of()));
    }
}
