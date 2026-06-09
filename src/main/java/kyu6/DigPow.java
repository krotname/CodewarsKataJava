package kyu6;


import java.util.concurrent.atomic.AtomicInteger;


public class DigPow {

    public static long digPow(int n, int p) {
        AtomicInteger pa = new AtomicInteger(p);
        int sum = String.valueOf(n)
                .chars()
                .map(Character::getNumericValue)
                .map(i -> (int) Math.pow(i, pa.getAndIncrement()))
                .sum();
        return sum % n == 0 ? sum / n : -1;
    }

}
