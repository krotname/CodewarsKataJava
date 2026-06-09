package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("smoke")
class PersistTest {

    private final Persist persist = new Persist();

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "7, 0",
            "39, 3",
            "999, 4",
            "4, 0",
            "25, 2"
    })
    void shouldCountMultiplicativePersistence(long number, int expectedCount) {
        assertEquals(expectedCount, persist.persistence(number));
    }
}
