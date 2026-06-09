package other;


import java.util.ArrayList;
import java.util.List;


// Просчитывает варианты numDigits`значных чисел в которых сумма чисел равна sumDigits и цифры идут по порядку
// и выводит массив количество найденых цифр, первое и последние

public class HowManyNumbers {

    private static long sumDigits(long n) {
        long result = 0;
        while (n > 0) {
            result = result + n % 10;
            n /= 10;
        }
        return result;
    }

    private static boolean digitsIncreasingOrder(long n) {
        long temp = n % 10;
        n /= 10;
        while (n > 0) {
            if (n % 10 > temp) return false;
            temp = n % 10;
            n /= 10;
        }
        return true;
    }

    public List<Long> findAll(final int sumDigits, final int numDigits) {
        long firstValue = 0L;
        long lastValue = 0L;
        long countValue = 0L;
        long start = (long) Math.pow(10, numDigits - 1.0);
        long finish = start * 10;
        for (long i = start; i < finish; i++) {
            if (digitsIncreasingOrder(i) && sumDigits(i) == sumDigits) {
                countValue++;
                lastValue = i;
                if (firstValue == 0L) firstValue = i;
            }
        }

        List<Long> result = new ArrayList<>(3);
        if (countValue > 0L) {
            result.add(countValue);
            result.add(firstValue);
            result.add(lastValue);
        }
        return result;
    }


}
