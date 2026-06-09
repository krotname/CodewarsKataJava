package kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class BraceCheckerTest {

    @ParameterizedTest
    @MethodSource("braceCases")
    void shouldValidateNestedBraceSequences(String braces, boolean expected) {
        assertEquals(expected, BraceChecker.isValid(braces));
    }

    private static Stream<Arguments> braceCases() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("()[]{}", true),
                Arguments.of("([{}])", true),
                Arguments.of("(}", false),
                Arguments.of("[(])", false),
                Arguments.of(")", false),
                Arguments.of("({[]})}", false),
                Arguments.of("((({{{[[[]]]}}})))", true)
        );
    }
}
