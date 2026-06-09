package kyu5;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class DirReductionTest {

    @Test
    void shouldRemoveAdjacentOppositeDirectionsRecursively() {
        assertArrayEquals(
                new String[]{"WEST"},
                DirReduction.dirReduce(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})
        );
        assertArrayEquals(
                new String[]{"WEST", "WEST"},
                DirReduction.dirReduce(new String[]{"NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"})
        );
    }

    @Test
    void shouldReturnEmptyArrayWhenAllDirectionsCancelOut() {
        assertArrayEquals(new String[0], DirReduction.dirReduce(new String[]{"NORTH", "SOUTH", "EAST", "WEST"}));
    }

    @Test
    void shouldKeepAlreadyReducedPath() {
        assertArrayEquals(new String[]{"NORTH", "WEST"}, DirReduction.dirReduce(new String[]{"NORTH", "WEST"}));
    }

    @Test
    void shouldRejectNullInput() {
        assertThrows(NullPointerException.class, () -> DirReduction.dirReduce(null));
    }
}
