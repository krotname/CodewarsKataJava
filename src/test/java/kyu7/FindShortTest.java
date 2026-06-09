package kyu7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@Tag("smoke")
class FindShortTest {

    @ParameterizedTest
    @CsvSource({
            "'bitcoin take over the world maybe who knows perhaps', 3",
            "'turns out random test cases are easier than writing out basic ones', 3",
            "'single', 6",
            "'  many   spaces here ', 4"
    })
    void shouldReturnShortestWordLength(String input, int expectedLength) {
        assertEquals(expectedLength, FindShort.findShort(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldReturnZeroForMissingInput(String input) {
        assertEquals(0, FindShort.findShort(input));
    }
}
