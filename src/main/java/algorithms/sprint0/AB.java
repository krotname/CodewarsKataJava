package algorithms.sprint0;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long sum = sum(a, b);
        System.out.println(sum);
    }

    public static long sum(int a, int b) {
        return (long) a + b;
    }

    @Test
    public void test() {
        assertEquals(5, sum(2, 3));
        assertEquals(-1, sum(-2, 1));
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "2,3,5",
            "-1,4,3",
            "2147483647,1,2147483648",
            "2000000000,2000000000,4000000000"
    })
    void sum_works(int a, int b, long expected) {
        assertEquals(expected, AB.sum(a, b));
    }

    @Test
    void main_prints_sum_basic() {
        String in = "2 3\n";
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            System.setOut(new PrintStream(buf, true, StandardCharsets.UTF_8));

            AB.main(new String[0]);

            String nl = System.lineSeparator();
            assertEquals("5" + nl, buf.toString(StandardCharsets.UTF_8));
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }

    @Test
    void main_bad_input_throws() {
        System.setIn(new ByteArrayInputStream("x y\n".getBytes(StandardCharsets.UTF_8)));
        assertThrows(InputMismatchException.class, () -> AB.main(new String[0]));
    }
}
