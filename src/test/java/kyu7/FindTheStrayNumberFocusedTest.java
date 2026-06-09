package kyu7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
class FindTheStrayNumberFocusedTest {

    @Test
    void returnsZeroForNullOrTooShortInput() {
        assertEquals(0, FindTheStrayNumber.stray(null));
        assertEquals(0, FindTheStrayNumber.stray(new int[]{1, 2}));
    }

    @Test
    void findsStrayNumberWhenBaseIsEstablishedByDifferentPairs() {
        assertEquals(2, FindTheStrayNumber.stray(new int[]{1, 1, 2}));
        assertEquals(2, FindTheStrayNumber.stray(new int[]{1, 2, 1}));
        assertEquals(2, FindTheStrayNumber.stray(new int[]{2, 1, 1}));
        assertEquals(7, FindTheStrayNumber.stray(new int[]{3, 3, 3, 7, 3}));
    }

    @Test
    void returnsZeroWhenEveryValueMatchesTheBase() {
        assertEquals(0, FindTheStrayNumber.stray(new int[]{5, 5, 5}));
    }
}
