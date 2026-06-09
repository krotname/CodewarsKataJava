package kyu7;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Tag;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static kyu7.SumOddNumbers.rowSumOddNumbers;

@Tag("property")
class SumOddNumbersPropertyTest {

    @Property
    void rowSumOddNumbersMatchesCube(@ForAll @IntRange(min = 1, max = 25) int n) {
        int actual = rowSumOddNumbers(n);
        int expected = n * n * n;
        assertEquals(expected, actual);
    }
}
