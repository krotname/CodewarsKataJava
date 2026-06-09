package kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
class MultiplesOf3or5FocusedTest {

    @Test
    void returnsZeroWhenThereAreNoPositiveMultiplesBelowLimit() {
        assertEquals(0, MultiplesOf3or5.multiplesOf3or5(-10));
        assertEquals(0, MultiplesOf3or5.multiplesOf3or5(0));
        assertEquals(0, MultiplesOf3or5.multiplesOf3or5(3));
    }

    @Test
    void sumsMultiplesOfThreeOrFiveOnce() {
        assertEquals(23, MultiplesOf3or5.multiplesOf3or5(10));
        assertEquals(60, MultiplesOf3or5.multiplesOf3or5(16));
    }

    @Test
    void streamImplementationMatchesImperativeImplementation() {
        MultiplesOf3or5 solution = new MultiplesOf3or5();

        assertEquals(23, solution.multiplesOf3or5Stream(10));
        assertEquals(MultiplesOf3or5.multiplesOf3or5(100), solution.multiplesOf3or5Stream(100));
    }
}
