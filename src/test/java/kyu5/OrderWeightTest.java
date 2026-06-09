package kyu5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@Tag("smoke")
class OrderWeightTest {

    @ParameterizedTest
    @CsvSource({
            "'56 65 74 100 99 68 86 180 90', '100 180 90 56 65 74 68 86 99'",
            "'103 123 4444 99 2000', '2000 103 123 4444 99'",
            "' 2000   10003 1234000 44444444 9999 11 11 22 123 ', '11 11 2000 10003 22 123 1234000 44444444 9999'"
    })
    void shouldOrderWeightsByDigitSumThenLexicographically(String input, String expected) {
        assertEquals(expected, OrderWeight.orderWeight(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldReturnEmptyStringForMissingInput(String input) {
        assertEquals("", OrderWeight.orderWeight(input));
    }
}
