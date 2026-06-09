package kyu6;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class StringSplitTest {

    @Test
    void shouldSplitEvenLengthStringIntoPairs() {
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, StringSplit.solution("abcdef"));
    }

    @Test
    void shouldPadOddLengthString() {
        assertArrayEquals(new String[]{"ab", "c_"}, StringSplit.solution("abc"));
    }

    @Test
    void shouldHandleEmptyString() {
        assertArrayEquals(new String[0], StringSplit.solution(""));
    }

    @Test
    void shouldRejectNullInput() {
        assertThrows(IllegalArgumentException.class, () -> StringSplit.solution(null));
    }
}
