package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class StonesAndJewelryAlgorithmsTest {

    @Test
    void bothImplementationsShouldCountJewelsInStones() {
        assertEquals(3, StonesAndJewelryY.countJewels("aA", "aAAbbbb"));
        assertEquals(3, StonesAndJewelryE.countJewels("aA", "aAAbbbb"));
    }

    @Test
    void bothImplementationsShouldReturnZeroWhenNoStoneMatches() {
        assertEquals(0, StonesAndJewelryY.countJewels("z", "ZZ"));
        assertEquals(0, StonesAndJewelryE.countJewels("z", "ZZ"));
    }

    @Test
    void bothImplementationsShouldHandleNullAndEmptyInputs() {
        assertEquals(0, StonesAndJewelryY.countJewels(null, "abc"));
        assertEquals(0, StonesAndJewelryY.countJewels("a", null));
        assertEquals(0, StonesAndJewelryY.countJewels("", "abc"));
        assertEquals(0, StonesAndJewelryE.countJewels(null, "abc"));
        assertEquals(0, StonesAndJewelryE.countJewels("a", null));
        assertEquals(0, StonesAndJewelryE.countJewels("", "abc"));
    }
}
