package algorithms.sprint0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("unit")
class ABTest {

    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "2,3,5",
            "-1,4,3",
            "2147483647,1,2147483648",
            "2000000000,2000000000,4000000000"
    })
    void sumWorks(int a, int b, long expected) {
        assertEquals(expected, AB.sum(a, b));
    }

    @Test
    void mainPrintsSum() {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream("2 3%n".formatted().getBytes(StandardCharsets.UTF_8)));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

            AB.main(new String[0]);

            assertEquals("5" + System.lineSeparator(), output.toString(StandardCharsets.UTF_8));
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }

    @Test
    void mainRejectsNonNumericInput() {
        InputStream oldIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream("x y%n".formatted().getBytes(StandardCharsets.UTF_8)));
            assertThrows(InputMismatchException.class, () -> AB.main(new String[0]));
        } finally {
            System.setIn(oldIn);
        }
    }
}
