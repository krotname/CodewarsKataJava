package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class SequentialOneTest {

    @ParameterizedTest
    @MethodSource("binaryStrings")
    void shouldCalculateLongestRunOfOnes(String input, int expected) {
        assertEquals(expected, new SequentialOne().calculate(input));
    }

    static Stream<Arguments> binaryStrings() {
        return Stream.of(
                Arguments.of("001111010111", 4),
                Arguments.of("0000", 0),
                Arguments.of("1111", 4),
                Arguments.of("10110111", 3),
                Arguments.of("", 0),
                Arguments.of(null, 0)
        );
    }
}
