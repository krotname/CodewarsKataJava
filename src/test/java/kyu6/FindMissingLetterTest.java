package kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class FindMissingLetterTest {

    @ParameterizedTest
    @MethodSource("letterCases")
    void shouldFindMissingLetterInContiguousRange(char[] letters, char expected) {
        assertEquals(expected, FindMissingLetter.findMissingLetter(letters));
    }

    private static Stream<Arguments> letterCases() {
        return Stream.of(
                Arguments.of(new char[]{'a', 'b', 'c', 'e'}, 'd'),
                Arguments.of(new char[]{'O', 'Q', 'R', 'S'}, 'P'),
                Arguments.of(new char[]{'x', 'z'}, 'y'),
                Arguments.of(new char[]{'A', 'B', 'C'}, ' ')
        );
    }
}
