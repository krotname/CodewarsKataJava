package kyu5;




public class ProductFib {

    //5

    public static long[] productFib(long prod) {
        long n = 0, i = 1;
        while (n < prod) {
            n = getFibonacciValue(i) * getFibonacciValue(i + 1);
            i++;
        }
        return new long[]{getFibonacciValue(i - 1), getFibonacciValue(i), n == prod ? 1 : 0};
    }

    public static long getFibonacciValue(final long n) {
        // https://ru.stackoverflow.com/questions/39229/Последовательности-чисел-Фибоначчи
        double p = (1 + Math.sqrt(5)) / 2;
        double q = 1 / p;
        return (long) ((Math.pow(p, n) + Math.pow(q, n)) / Math.sqrt(5));
    }

    /**
     * The Fibonacci numbers are the numbers in the following integer sequence (Fn):
     * <p>
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
     * <p>
     * such as
     * <p>
     * F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.
     * <p>
     * Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying
     * <p>
     * F(n) * F(n+1) = prod.
     * <p>
     * Your function productFib takes an integer (prod) and returns an array:
     * <p>
     * [F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True)
     * depending on the language if F(n) * F(n+1) = prod.
     * <p>
     * If you don't find two consecutive F(n) verifying F(n) * F(n+1) = prodyou will return
     * <p>
     * [F(n), F(n+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False)
     * F(n) being the smallest one such as F(n) * F(n+1) > prod.
     * <p>
     * Some Examples of Return:
     * (depend on the language)
     * <p>
     * productFib(714) # should return (21, 34, true),
     * # since F(8) = 21, F(9) = 34 and 714 = 21 * 34
     * <p>
     * productFib(800) # should return (34, 55, false),
     * # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55
     * -----
     * productFib(714) # should return [21, 34, true],
     * productFib(800) # should return [34, 55, false],
     * -----
     * productFib(714) # should return {21, 34, 1},
     * productFib(800) # should return {34, 55, 0},
     * -----
     * productFib(714) # should return {21, 34, true},
     * productFib(800) # should return {34, 55, false},
     * Note:
     * You can see examples for your language in "Sample Tests"
     */


}
