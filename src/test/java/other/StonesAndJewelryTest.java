package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class StonesAndJewelryTest {

    @Test
    void shouldCountJewelsInStones() {
        StonesAndJewelry service = new StonesAndJewelry();

        assertEquals(3, service.calculate("aA", "aAAbbbb"));
        assertEquals(0, service.calculate("z", "ZZ"));
    }

    @Test
    void shouldHandleNullAndEmptyInputs() {
        StonesAndJewelry service = new StonesAndJewelry();

        assertEquals(0, service.calculate(null, "abc"));
        assertEquals(0, service.calculate("a", null));
        assertEquals(0, service.calculate("", "abc"));
        assertEquals(0, service.calculate("abc", ""));
    }
}
