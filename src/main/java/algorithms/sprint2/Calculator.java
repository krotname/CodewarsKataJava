import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
Принцип работы алгоритма:
- Выражение в обратной польской нотации читается слева направо по токенам (разделитель — пробел).
- Используется стек целых чисел.
  * Если токен — число, кладём его в стек.
  * Если токен — операция (+, -, *, /), достаём два верхних значения b и a (сначала b, потом a),
    вычисляем a (op) b и результат кладём обратно в стек.
- После обработки всех токенов ответ — верхний элемент стека (даже если элементов больше одного).

Корректность:
- Инвариант: после обработки первых i токенов стек содержит значения всех уже полностью вычисленных
  подвыражений, которые по правилам ОПН должны ждать дальнейших операций.
- При чтении числа инвариант сохраняется: число становится готовым операндом и помещается в стек.
- При чтении операции по определению ОПН она применяется к двум ближайшим слева операндам,
  которые и лежат на вершине стека в нужном порядке добавления. Мы снимаем b и a и кладём результат,
  тем самым заменяя эти два операнда на значение их подвыражения — инвариант сохраняется.
- Для деления используется Math.floorDiv(a, b), что соответствует требованию “округление вниз” (floor).
  По условию деления на отрицательное число нет, но a может быть отрицательным — floorDiv это корректно обрабатывает.

Оценка сложности:
- Время: O(m), где m — число токенов (каждый токен обрабатывается за O(1)).
- Память: O(s), где s — максимальный размер стека (в худшем случае O(m)).
*/
public class Calculator {

    // -------------------- SOLUTION --------------------
    static int evalRpn(FastIn in) throws IOException {
        IntStack st = new IntStack(64);

        String tok;
        while ((tok = in.nextOrNull()) != null) {
            if (tok.length() == 1) {
                char op = tok.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    int b = st.pop();
                    int a = st.pop();

                    int r;
                    if (op == '+') {
                        r = a + b;
                    } else if (op == '-') {
                        r = a - b;
                    } else if (op == '*') {
                        r = a * b;
                    } else {
                        r = Math.floorDiv(a, b);
                    }

                    st.push(r);
                    continue;
                }
            }
            st.push(Integer.parseInt(tok));
        }

        return st.peek();
    }

    // -------------------- INT STACK --------------------
    static final class IntStack {
        private int[] a;
        private int sz;

        IntStack(int cap) {
            this.a = new int[Math.max(2, cap)];
            this.sz = 0;
        }

        void push(int v) {
            if (sz == a.length) {
                int[] b = new int[a.length << 1];
                System.arraycopy(a, 0, b, 0, a.length);
                a = b;
            }
            a[sz++] = v;
        }

        int pop() {
            return a[--sz];
        }

        int peek() {
            return a[sz - 1];
        }
    }

    // -------------------- FAST INPUT --------------------
    static final class FastIn {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastIn(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buf);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buf[ptr++];
        }

        String nextOrNull() throws IOException {
            int c;
            do {
                c = read();
                if (c == -1) {
                    return null;
                }
            } while (c <= ' ');

            byte[] tmp = new byte[32];
            int n = 0;

            while (c > ' ') {
                if (n == tmp.length) {
                    byte[] t2 = new byte[tmp.length << 1];
                    System.arraycopy(tmp, 0, t2, 0, tmp.length);
                    tmp = t2;
                }
                tmp[n++] = (byte) c;

                c = read();
                if (c == -1) {
                    break;
                }
            }

            return new String(tmp, 0, n);
        }
    }

    // -------------------- FAST OUTPUT --------------------
    static final class FastOut {
        private final OutputStream out;
        private final byte[] buf = new byte[1 << 16];
        private int p = 0;
        private final byte[] tmp = new byte[12];

        FastOut(OutputStream out) {
            this.out = out;
        }

        void writeByte(int b) throws IOException {
            if (p == buf.length) {
                flush();
            }
            buf[p++] = (byte) b;
        }

        void writeInt(int x) throws IOException {
            if (x == 0) {
                writeByte('0');
                return;
            }
            if (x < 0) {
                writeByte('-');
                x = -x;
            }

            int k = 0;
            while (x > 0) {
                tmp[k++] = (byte) ('0' + (x % 10));
                x /= 10;
            }
            for (int i = k - 1; i >= 0; i--) {
                writeByte(tmp[i]);
            }
        }

        void flush() throws IOException {
            out.write(buf, 0, p);
            p = 0;
        }
    }

    private static void run() throws Exception {
        FastIn in = new FastIn(System.in);
        FastOut out = new FastOut(System.out);

        int ans = evalRpn(in);

        out.writeInt(ans);
        out.writeByte('\n');
        out.flush();
    }

    private static void test() throws Exception {
        assertEq(9, evalFromString("2 1 + 3 *"));
        assertEq(38, evalFromString("7 2 + 4 * 2 +"));

        // деление “вниз”
        assertEq(-1, evalFromString("-1 3 /"));
        assertEq(-2, evalFromString("-4 3 /"));

        // порядок операндов
        assertEq(2, evalFromString("10 2 4 * -"));

        // одно число
        assertEq(5, evalFromString("5"));

        System.out.println("Test OK");
    }

    private static int evalFromString(String s) throws Exception {
        InputStream is = new java.io.ByteArrayInputStream(
                s.getBytes(java.nio.charset.StandardCharsets.US_ASCII)
        );
        return evalRpn(new FastIn(is));
    }

    static void assertEq(int exp, int act) {
        if (exp != act) {
            throw new AssertionError("Expected=" + exp + ", actual=" + act);
        }
    }

    public static void main(String[] args) throws Exception {
        if (System.getProperty("os.name").startsWith("Windows")) {
            test();
        } else {
            run();
        }
    }
}
