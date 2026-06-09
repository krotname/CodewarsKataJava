package interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class BracketsTest {

    @ParameterizedTest
    @MethodSource("bracketCases")
    void shouldValidateBalancedBrackets(String input, boolean expected) {
        assertEquals(expected, Brackets.check(input));
    }

    static Stream<Arguments> bracketCases() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("plain text", true),
                Arguments.of("([]{})", true),
                Arguments.of("a(b[c]{d})", true),
                Arguments.of("(", false),
                Arguments.of("([)]", false),
                Arguments.of("())", false),
                Arguments.of(null, false)
        );
    }
}
