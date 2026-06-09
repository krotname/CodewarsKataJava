package kyu4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class TimeFormatterTest {

    @ParameterizedTest
    @MethodSource("durationCases")
    void shouldFormatDurationsInNaturalLanguage(int seconds, String expected) {
        assertEquals(expected, TimeFormatter.formatDuration(seconds));
    }

    private static Stream<Arguments> durationCases() {
        return Stream.of(
                Arguments.of(-1, "now"),
                Arguments.of(0, "now"),
                Arguments.of(1, "1 second"),
                Arguments.of(62, "1 minute and 2 seconds"),
                Arguments.of(120, "2 minutes"),
                Arguments.of(3_600, "1 hour"),
                Arguments.of(3_662, "1 hour, 1 minute and 2 seconds"),
                Arguments.of(86_400, "1 day"),
                Arguments.of(31_536_000, "1 year"),
                Arguments.of(31_626_061, "1 year, 1 day, 1 hour, 1 minute and 1 second"),
                Arguments.of(63_252_122, "2 years, 2 days, 2 hours, 2 minutes and 2 seconds")
        );
    }
}
