package kyu7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@Tag("smoke")
class HighAndLowTest {

    @ParameterizedTest
    @CsvSource({
            "'1 2 3 4 5', '5 1'",
            "'1 2 -3 4 5', '5 -3'",
            "'1 9 3 4 -5', '9 -5'",
            "'  42   7  13 ', '42 7'"
    })
    void shouldReturnHighestAndLowestNumbers(String input, String expected) {
        assertEquals(expected, HighAndLow.highAndLow(input));
    }

    @ParameterizedTest
    @CsvSource({
            "'1 2 3 4 5', 5",
            "'-10 -3 -7', -3",
            "'  42   7  13 ', 42"
    })
    void shouldReturnHighestNumber(String input, int expected) {
        assertEquals(expected, HighAndLow.high(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldRejectMissingNumbers(String input) {
        assertThrows(RuntimeException.class, () -> HighAndLow.highAndLow(input));
        assertThrows(RuntimeException.class, () -> HighAndLow.high(input));
    }
}
