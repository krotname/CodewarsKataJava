package kyu4;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class IntervalTest {

    @Test
    void shouldReturnZeroForMissingIntervals() {
        assertEquals(0, Interval.sumIntervals(null));
        assertEquals(0, Interval.sumIntervals(new int[0][0]));
    }

    @Test
    void shouldSumDisjointAndZeroLengthIntervals() {
        assertEquals(3, Interval.sumIntervals(new int[][]{{1, 2}, {3, 5}, {7, 7}}));
    }

    @Test
    void shouldMergeOverlappingAndTouchingIntervals() {
        assertEquals(7, Interval.sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}}));
        assertEquals(19, Interval.sumIntervals(new int[][]{{1, 5}, {5, 10}, {-10, 0}}));
    }

    @Test
    void shouldNotMutateInputIntervals() {
        int[][] intervals = {{5, 10}, {1, 4}};

        assertEquals(8, Interval.sumIntervals(intervals));
        assertArrayEquals(new int[][]{{5, 10}, {1, 4}}, intervals);
    }

    @Test
    void shouldRejectInvalidIntervals() {
        assertThrows(IllegalArgumentException.class, () -> Interval.sumIntervals(new int[][]{null}));
        assertThrows(IllegalArgumentException.class, () -> Interval.sumIntervals(new int[][]{{1}}));
        assertThrows(IllegalArgumentException.class, () -> Interval.sumIntervals(new int[][]{{2, 1}}));
    }
}
