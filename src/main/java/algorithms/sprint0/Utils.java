package algorithms.sprint0;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    public static List<Integer> readList(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null) throw new NumberFormatException("EOF");
        return Arrays.stream(line.trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static <T> void printList(List<T> list, Writer writer) {
        for (T elem : list) {
            try {
                writer.write(String.valueOf(elem));
                writer.write(" ");
            } catch (IOException ignored) {
            }
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null) throw new NumberFormatException("EOF");
        return Integer.parseInt(line);
    }

    @Test
    public void readListbasic() throws Exception {
        BufferedReader br = new BufferedReader(new StringReader("1 2 3"));
        List<Integer> got = readList(br);
        assertEquals(Arrays.asList(1, 2, 3), got);
    }

    @Test
    void readList_mixedWhitespace_and_signs() throws Exception {
        BufferedReader br = new BufferedReader(new StringReader("  -1\t0   5  "));
        List<Integer> got = readList(br);
        assertEquals(Arrays.asList(-1, 0, 5), got);
    }

    @Test
    void readList_emptyLine_throwsNumberFormat() {
        BufferedReader br = new BufferedReader(new StringReader("\\n"));
        assertThrows(NumberFormatException.class, () -> readList(br));
    }

    @Test
    void readList_EOF_throwsNumberFormat() {
        BufferedReader br = new BufferedReader(new StringReader(""));
        assertThrows(NumberFormatException.class, () -> readList(br));
    }

    @Test
    void readList_nonIntegerToken_throwsNumberFormat() {
        BufferedReader br = new BufferedReader(new StringReader("1 a 3"));
        assertThrows(NumberFormatException.class, () -> readList(br));
    }

    @Test
    void readList_overflow_throwsNumberFormat() {
        BufferedReader br = new BufferedReader(new StringReader("2147483648"));
        assertThrows(NumberFormatException.class, () -> readList(br));
    }

    // --- readInt ---

    @Test
    void readInt_basic() throws Exception {
        BufferedReader br = new BufferedReader(new StringReader("42"));
        assertEquals(42, readInt(br));
    }

    @Test
    void readInt_negative() throws Exception {
        BufferedReader br = new BufferedReader(new StringReader("-7"));
        assertEquals(-7, readInt(br));
    }

    @Test
    void readInt_withSpaces_throwsNumberFormat() {
        BufferedReader br = new BufferedReader(new StringReader(" 42 "));
        assertThrows(NumberFormatException.class, () -> readInt(br));
    }

    // --- printList ---

    @Test
    void printList_integers_trailingSpace_noNewline() throws Exception {
        StringWriter sw = new StringWriter();
        printList(Arrays.asList(1, 2, 3), sw);
        assertEquals("1 2 3 ", sw.toString());
    }

    @Test
    void printList_strings_usesToString() throws Exception {
        StringWriter sw = new StringWriter();
        printList(Arrays.asList("a", "b"), sw);
        assertEquals("a b ", sw.toString());
    }

    @Test
    void printList_empty_writesNothing() throws Exception {
        StringWriter sw = new StringWriter();
        printList(List.of(), sw);
        assertEquals("", sw.toString());
    }

    @Test
    void printList_ioExceptions_areSwallowed() {
        Writer throwing = new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {
                throw new IOException("boom");
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() {
            }

            @Override
            public void write(String str) throws IOException {
                throw new IOException("boom");
            }

            @Override
            public void write(int c) throws IOException {
                throw new IOException("boom");
            }
        };
        assertDoesNotThrow(() -> printList(Arrays.asList(1, 2, 3), throwing));
    }
}
