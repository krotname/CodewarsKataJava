package coderun;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class AverageElementTest {

    @Test
    void shouldReturnMiddleValueAfterSortingThreeNumbers() {
        assertEquals(5, AverageElement.average(new String[]{"10", "5", "1"}));
    }

    @Test
    void shouldHandleNegativeValues() {
        assertEquals(-2, AverageElement.average(new String[]{"-10", "-2", "7"}));
    }

    @Test
    void shouldSolveFromReaderAndNormalizeWhitespace() throws IOException {
        StringWriter output = new StringWriter();

        AverageElement.solve(new StringReader("10   5  1"), output);

        assertEquals("5", output.toString());
    }
}
