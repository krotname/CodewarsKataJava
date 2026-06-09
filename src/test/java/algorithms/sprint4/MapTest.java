package algorithms.sprint4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.OptionalInt;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
class MapTest {

    @Test
    void hashTableSupportsPutGetUpdateAndDelete() {
        Map.HashTable table = new Map.HashTable();

        table.put(1, 10);
        table.put(1, 20);

        assertEquals(OptionalInt.of(20), table.get(1));
        assertEquals(OptionalInt.of(20), table.delete(1));
        assertTrue(table.get(1).isEmpty());
        assertTrue(table.delete(1).isEmpty());
    }

    @Test
    void hashTableHandlesCollisionsAndNegativeKeys() {
        Map.HashTable table = new Map.HashTable();

        table.put(5, 50);
        table.put(100_008, 60);
        table.put(-5, 70);

        assertEquals(OptionalInt.of(50), table.get(5));
        assertEquals(OptionalInt.of(60), table.get(100_008));
        assertEquals(OptionalInt.of(70), table.get(-5));
    }
}
