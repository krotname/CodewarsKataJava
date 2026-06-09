package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

@Tag("smoke")
class AnagramsTest {

    @ParameterizedTest
    @CsvSource({
            "listen, silent",
            "'conversation', 'conservation'",
            "aab, aba"
    })
    void shouldAcceptAnagrams(String first, String second) {
        assertEquals(1, Anagrams.check(first, second));
    }

    @ParameterizedTest
    @CsvSource({
            "aab, abb",
            "abc, abcd",
            "test, taste"
    })
    void shouldRejectNonAnagrams(String first, String second) {
        assertEquals(0, Anagrams.check(first, second));
    }

    @ParameterizedTest
    @NullSource
    void shouldRejectNullFirstValue(String first) {
        assertEquals(0, Anagrams.check(first, "abc"));
    }

    @ParameterizedTest
    @NullSource
    void shouldRejectNullSecondValue(String second) {
        assertEquals(0, Anagrams.check("abc", second));
    }
}
