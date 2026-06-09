package kyu7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class MetroTest {

    @Test
    void shouldCountPassengersAfterAllStops() {
        assertEquals(5, Metro.countPassengers(List.of(new int[]{10, 0}, new int[]{3, 5}, new int[]{5, 8})));
    }

    @Test
    void shouldReturnZeroForMissingStops() {
        assertEquals(0, Metro.countPassengers(null));
        assertEquals(0, Metro.countPassengers(List.of()));
    }

    @Test
    void shouldRejectMalformedStops() {
        assertThrows(IllegalArgumentException.class, () -> Metro.countPassengers(List.of(new int[]{1})));
    }
}
