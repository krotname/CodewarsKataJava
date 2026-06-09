package kyu5;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("smoke")
class WhoIsNextTest {
    private static final String[] NAMES = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};

    @ParameterizedTest
    @MethodSource("queuePositions")
    void shouldResolveQueuePositionWithoutExpandingQueue(int n, String expectedName) {
        assertEquals(expectedName, WhoIsNext.whoIsNext(NAMES, n));
        assertEquals(expectedName, WhoIsNext.whoIsNextLinkedList(NAMES, n));
    }

    @ParameterizedTest
    @MethodSource("invalidInputs")
    void shouldRejectInvalidInputs(String[] names, int n) {
        assertThrows(IllegalArgumentException.class, () -> WhoIsNext.whoIsNext(names, n));
    }

    @org.junit.jupiter.api.Test
    void shouldNotMutateNamesArray() {
        String[] names = NAMES.clone();

        WhoIsNext.whoIsNext(names, 52);

        assertArrayEquals(NAMES, names);
    }

    static Stream<Arguments> queuePositions() {
        return Stream.of(
                Arguments.of(1, "Sheldon"),
                Arguments.of(5, "Howard"),
                Arguments.of(6, "Sheldon"),
                Arguments.of(7, "Sheldon"),
                Arguments.of(8, "Leonard"),
                Arguments.of(52, "Penny"),
                Arguments.of(723_070_295, "Sheldon"),
                Arguments.of(805_306_364, "Leonard")
        );
    }

    static Stream<Arguments> invalidInputs() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of(new String[0], 1),
                Arguments.of(NAMES, 0)
        );
    }
}
