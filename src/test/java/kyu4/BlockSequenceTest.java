package kyu4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("smoke")
class BlockSequenceTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 1",
            "5, 2",
            "6, 3",
            "10, 4",
            "20, 5",
            "50, 5",
            "100, 1",
            "250, 5",
            "1000, 4",
            "10000, 9",
            "100000, 2",
            "1000000, 6"
    })
    void shouldReturnDigitAtOneBasedSequencePosition(long position, int expectedDigit) {
        assertEquals(expectedDigit, BlockSequence.solve(position));
    }

    @ParameterizedTest
    @CsvSource({"0", "-1"})
    void shouldRejectNonPositivePositions(long position) {
        assertThrows(IllegalArgumentException.class, () -> BlockSequence.solve(position));
    }
}
