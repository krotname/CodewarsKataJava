package other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class StreamMainTest {

    @Test
    void shouldExposeReadableStreamExerciseResults() {
        assertEquals(List.of(300, 300), StreamMain.transactionsIn2011SortedByValue());
        assertEquals(List.of("Cambridge", "Milan"), StreamMain.traderCities());
        assertEquals(List.of("Alan", "Brian", "Raule"), StreamMain.cambridgeTraderNames());
        assertTrue(StreamMain.hasTraderInMilan());
        assertEquals(1_000, StreamMain.highestTransactionValue());
        assertEquals(2_550, StreamMain.totalValueFromCambridge());
    }
}
