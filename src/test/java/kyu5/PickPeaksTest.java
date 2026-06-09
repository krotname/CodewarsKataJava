package kyu5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class PickPeaksTest {

    @Test
    void shouldPickSinglePointPeaks() {
        assertEquals(
                Map.of("pos", List.of(3, 7), "peaks", List.of(6, 3)),
                PickPeaks.getPeaks(new int[]{1, 2, 3, 6, 4, 1, 2, 3, 2, 1})
        );
    }

    @Test
    void shouldPickPlateauPeakAtPlateauStart() {
        assertEquals(
                Map.of("pos", List.of(3), "peaks", List.of(6)),
                PickPeaks.getPeaks(new int[]{1, 2, 3, 6, 6, 6, 4, 1})
        );
    }

    @Test
    void shouldIgnorePlateauThatNeverFalls() {
        assertEquals(
                Map.of("pos", List.of(), "peaks", List.of()),
                PickPeaks.getPeaks(new int[]{1, 2, 2, 2})
        );
    }

    @Test
    void shouldReturnEmptyResultForMissingInput() {
        assertEquals(Map.of("pos", List.of(), "peaks", List.of()), PickPeaks.getPeaks(null));
        assertEquals(Map.of("pos", List.of(), "peaks", List.of()), PickPeaks.getPeaks(new int[0]));
    }
}
