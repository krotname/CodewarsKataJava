package kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class FindOddTest {

    @ParameterizedTest
    @MethodSource("oddOccurrenceCases")
    void shouldFindValueWithOddOccurrenceCount(int[] values, int expected) {
        assertEquals(expected, FindOdd.findIt(values));
    }

    @Test
    void shouldReturnZeroWhenInputDoesNotContainOddOccurrence() {
        assertEquals(0, FindOdd.findIt(null));
        assertEquals(0, FindOdd.findIt(new int[0]));
    }

    static Stream<Arguments> oddOccurrenceCases() {
        return Stream.of(
                Arguments.of(new int[]{7}, 7),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1, 1, 2}, 2),
                Arguments.of(new int[]{0, 1, 0, 1, 0}, 0),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}, 4),
                Arguments.of(new int[]{-1, -1, -2}, -2)
        );
    }
}
