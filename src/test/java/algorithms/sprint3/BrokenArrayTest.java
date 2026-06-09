package algorithms.sprint3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
class BrokenArrayTest {

    @Test
    void findsTargetInRotatedArray() {
        assertEquals(6, BrokenArray.brokenSearch(new int[]{19, 21, 100, 101, 1, 4, 5, 7, 12}, 5));
        assertEquals(1, BrokenArray.brokenSearch(new int[]{5, 1}, 1));
        assertEquals(4, BrokenArray.brokenSearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void findsTargetInSortedOrSingleElementArrays() {
        assertEquals(3, BrokenArray.brokenSearch(new int[]{1, 2, 3, 4, 5, 6}, 4));
        assertEquals(0, BrokenArray.brokenSearch(new int[]{1}, 1));
    }

    @Test
    void returnsMinusOneWhenTargetIsAbsent() {
        assertEquals(-1, BrokenArray.brokenSearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, BrokenArray.brokenSearch(new int[]{1}, 2));
    }
}
