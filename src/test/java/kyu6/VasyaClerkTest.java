package kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class VasyaClerkTest {

    @ParameterizedTest
    @MethodSource("queueCases")
    void shouldDecideWhetherVasyaCanGiveChange(int[] queue, String expected) {
        assertEquals(expected, VasyaClerk.Tickets(queue));
    }

    private static Stream<Arguments> queueCases() {
        return Stream.of(
                Arguments.of(null, "YES"),
                Arguments.of(new int[0], "YES"),
                Arguments.of(new int[]{25, 25, 50}, "YES"),
                Arguments.of(new int[]{25, 25, 25, 100}, "YES"),
                Arguments.of(new int[]{25, 50, 25, 100}, "YES"),
                Arguments.of(new int[]{50}, "NO"),
                Arguments.of(new int[]{25, 100}, "NO"),
                Arguments.of(new int[]{25, 25, 50, 50, 100}, "NO")
        );
    }
}
