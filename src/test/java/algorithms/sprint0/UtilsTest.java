package algorithms.sprint0;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
class UtilsTest {

    @Test
    void readListParsesIntegers() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("1 2 3"));

        assertEquals(Arrays.asList(1, 2, 3), Utils.readList(reader));
    }

    @Test
    void readListAcceptsMixedWhitespaceAndSigns() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("  -1\t0   5  "));

        assertEquals(Arrays.asList(-1, 0, 5), Utils.readList(reader));
    }

    @Test
    void readListRejectsMalformedInput() {
        assertThrows(NumberFormatException.class,
                () -> Utils.readList(new BufferedReader(new StringReader("%n".formatted()))));
        assertThrows(NumberFormatException.class,
                () -> Utils.readList(new BufferedReader(new StringReader(""))));
        assertThrows(NumberFormatException.class,
                () -> Utils.readList(new BufferedReader(new StringReader("1 a 3"))));
        assertThrows(NumberFormatException.class,
                () -> Utils.readList(new BufferedReader(new StringReader("2147483648"))));
    }

    @Test
    void readIntParsesPlainIntegerLine() throws IOException {
        assertEquals(42, Utils.readInt(new BufferedReader(new StringReader("42"))));
        assertEquals(-7, Utils.readInt(new BufferedReader(new StringReader("-7"))));
    }

    @Test
    void readIntRejectsWrappedSpaces() {
        assertThrows(NumberFormatException.class,
                () -> Utils.readInt(new BufferedReader(new StringReader(" 42 "))));
    }

    @Test
    void printListWritesValuesWithTrailingSpaces() {
        StringWriter numbers = new StringWriter();
        StringWriter strings = new StringWriter();
        StringWriter empty = new StringWriter();

        Utils.printList(Arrays.asList(1, 2, 3), numbers);
        Utils.printList(Arrays.asList("a", "b"), strings);
        Utils.printList(List.of(), empty);

        assertEquals("1 2 3 ", numbers.toString());
        assertEquals("a b ", strings.toString());
        assertEquals("", empty.toString());
    }

    @Test
    void printListSwallowsWriterFailures() {
        Writer throwing = new ThrowingWriter();

        assertDoesNotThrow(() -> Utils.printList(Arrays.asList(1, 2, 3), throwing));
    }

    private static final class ThrowingWriter extends Writer {
        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            throw new IOException("boom");
        }

        @Override
        public void write(String str) throws IOException {
            throw new IOException("boom");
        }

        @Override
        public void write(int c) throws IOException {
            throw new IOException("boom");
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() {
        }
    }
}
