package kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class FindOutlierTest {

    @ParameterizedTest
    @MethodSource("outlierCases")
    void shouldFindSingleParityOutlier(int[] values, int expected) {
        assertEquals(expected, FindOutlier.find(values));
    }

    @Test
    void shouldRejectMissingOrTooShortInput() {
        assertThrows(IllegalArgumentException.class, () -> FindOutlier.find(null));
        assertThrows(IllegalArgumentException.class, () -> FindOutlier.find(new int[]{1, 2}));
    }

    @Test
    void shouldReturnMinusOneWhenThereIsNoOutlier() {
        assertEquals(-1, FindOutlier.find(new int[]{2, 4, 6, 8}));
    }

    private static Stream<Arguments> outlierCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}, 11),
                Arguments.of(new int[]{160, 3, 1719, 19, 11, 13, -21}, 160),
                Arguments.of(new int[]{1, 2, 3}, 2),
                Arguments.of(new int[]{2, 1, 4}, 1),
                Arguments.of(new int[]{-3, -5, -8, -7}, -8)
        );
    }
}
