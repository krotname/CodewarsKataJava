package kyu4;


import java.math.BigInteger;


public class BlockSequence {

    //4 https://www.codewars.com/kata/5e1ab1b9fe268c0033680e5f
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.valueOf(2L);

    public static int solve(long n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be positive");
        }

        long blockNumber = findContainingBlock(n);
        BigInteger previousLength = cumulativeLength(blockNumber - 1);
        BigInteger offsetInBlock = BigInteger.valueOf(n).subtract(previousLength);
        return digitAtOffset(blockNumber, offsetInBlock);
    }

    private static long findContainingBlock(long position) {
        BigInteger target = BigInteger.valueOf(position);
        long high = 1L;
        while (cumulativeLength(high).compareTo(target) < 0) {
            high *= 2L;
        }

        long low = 1L;
        while (low < high) {
            long middle = low + (high - low) / 2L;
            if (cumulativeLength(middle).compareTo(target) >= 0) {
                high = middle;
            } else {
                low = middle + 1L;
            }
        }
        return low;
    }

    private static BigInteger cumulativeLength(long blockNumber) {
        if (blockNumber <= 0) {
            return ZERO;
        }

        BigInteger result = ZERO;
        long groupStart = 1L;
        for (int digits = 1; groupStart <= blockNumber; digits++) {
            long groupEnd = groupStart > Long.MAX_VALUE / 10L
                    ? blockNumber
                    : Math.min(blockNumber, groupStart * 10L - 1L);
            BigInteger count = BigInteger.valueOf(groupEnd - groupStart + 1L);
            BigInteger rangeSum = BigInteger.valueOf(groupStart)
                    .add(BigInteger.valueOf(groupEnd))
                    .multiply(count)
                    .divide(TWO);

            BigInteger appearances = BigInteger.valueOf(blockNumber).add(ONE).multiply(count).subtract(rangeSum);
            result = result.add(BigInteger.valueOf(digits).multiply(appearances));
            groupStart = groupEnd + 1L;
        }
        return result;
    }

    private static int digitAtOffset(long blockNumber, BigInteger offset) {
        BigInteger remaining = offset;
        long groupStart = 1L;
        for (int digits = 1; groupStart <= blockNumber; digits++) {
            long groupEnd = groupStart > Long.MAX_VALUE / 10L
                    ? blockNumber
                    : Math.min(blockNumber, groupStart * 10L - 1L);
            BigInteger groupDigits = BigInteger.valueOf(groupEnd - groupStart + 1L).multiply(BigInteger.valueOf(digits));

            if (remaining.compareTo(groupDigits) > 0) {
                remaining = remaining.subtract(groupDigits);
            } else {
                BigInteger[] numberAndDigit = remaining.subtract(ONE).divideAndRemainder(BigInteger.valueOf(digits));
                long number = BigInteger.valueOf(groupStart).add(numberAndDigit[0]).longValueExact();
                return Character.digit(Long.toString(number).charAt(numberAndDigit[1].intValue()), 10);
            }

            groupStart = groupEnd + 1L;
        }
        throw new IllegalStateException("offset is outside of the containing block");
    }

    /**
     * <p>
     * /*Consider the following array:
     * <p>
     * [1, 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789, 12345678910, 1234567891011...]
     * If we join these blocks of numbers, we come up with an infinite sequence which starts with 112123123412345123456....
     * The list is infinite.
     * <p>
     * You will be given an number (n) and your task will be to return the element at that index in the sequence,
     * where 1 ≤ n ≤ 10^18. Assume the indexes start with 1, not 0. For example:
     * <p>
     * solve(1) = 1, because the first character in the sequence is 1. There is no index 0.
     * solve(2) = 1, because the second character is also 1.
     * solve(3) = 2, because the third character is 2.
     * More examples in the test cases.
     */


}
