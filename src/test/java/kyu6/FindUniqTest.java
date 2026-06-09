package kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class FindUniqTest {

    @ParameterizedTest
    @MethodSource("uniqueCases")
    void shouldFindOnlyDifferentNumber(double[] values, double expected) {
        assertEquals(expected, FindUniq.findUniq(values));
    }

    @ParameterizedTest
    @MethodSource("invalidCases")
    void shouldRejectInvalidInputs(double[] values) {
        assertThrows(IllegalArgumentException.class, () -> FindUniq.findUniq(values));
    }

    private static Stream<Arguments> uniqueCases() {
        return Stream.of(
                Arguments.of(new double[]{1, 1, 1, 2, 1, 1}, 2),
                Arguments.of(new double[]{0, 0, 0.55, 0, 0}, 0.55),
                Arguments.of(new double[]{3, 9, 3, 3, 3}, 9),
                Arguments.of(new double[]{-1, -1, -2}, -2)
        );
    }

    private static Stream<double[]> invalidCases() {
        return Stream.of(null, new double[]{1, 2}, new double[]{7, 7, 7});
    }
}
