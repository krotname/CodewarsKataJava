package other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.OptionalDouble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class RemovingDuplicatesYTest {

    @BeforeEach
    void resetState() {
        RemovingDuplicatesY.reset();
    }

    @Test
    void shouldReturnOnlyChangedConsecutiveValues() {
        assertValue(1.0, RemovingDuplicatesY.calc(1.0));
        assertFalse(RemovingDuplicatesY.calc(1.0).isPresent());
        assertValue(2.0, RemovingDuplicatesY.calc(2.0));
        assertFalse(RemovingDuplicatesY.calc(2.0).isPresent());
    }

    @Test
    void shouldNotLoseFirstValueEqualToPreviousSentinel() {
        assertValue(Double.MIN_VALUE, RemovingDuplicatesY.calc(Double.MIN_VALUE));
    }

    private static void assertValue(double expected, OptionalDouble actual) {
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.getAsDouble());
    }
}
