package kyu7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class BinaryArrayToNumberTest {

    @Test
    void shouldConvertBinaryDigitsToInteger() {
        assertEquals(0, BinaryArrayToNumber.convertBinaryArrayToInt(List.of()));
        assertEquals(1, BinaryArrayToNumber.convertBinaryArrayToInt(List.of(1)));
        assertEquals(13, BinaryArrayToNumber.convertBinaryArrayToInt(List.of(1, 1, 0, 1)));
        assertEquals(170, BinaryArrayToNumber.convertBinaryArrayToInt(List.of(1, 0, 1, 0, 1, 0, 1, 0)));
    }

    @Test
    void shouldRejectInvalidBinaryDigits() {
        assertThrows(IllegalArgumentException.class, () -> BinaryArrayToNumber.convertBinaryArrayToInt(null));
        assertThrows(IllegalArgumentException.class, () -> BinaryArrayToNumber.convertBinaryArrayToInt(List.of(1, 2)));
        assertThrows(
                IllegalArgumentException.class,
                () -> BinaryArrayToNumber.convertBinaryArrayToInt(Arrays.asList(1, null))
        );
    }
}
