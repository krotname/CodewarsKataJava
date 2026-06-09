package kyu6;


import java.util.stream.IntStream;


public class FindEvenIndex {

    public static int findEvenIndexV2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (findHalf1(arr, i) == findHalf2(arr, i)) {
                return i;
            }
        }
        return -1;
    }

    private static int findHalf1(int[] arr, int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += arr[j];
        }
        return sum;
    }

    private static int findHalf2(int[] arr, int i) {
        int sum = 0;
        for (int j = i + 1; j < arr.length; j++) {
            sum += arr[j];
        }
        return sum;

    }

    public static int findEvenIndexV1(int[] arr) {

        int sumArr = IntStream.of(arr).sum();
        int firstHalfSumm = 0;
        int secondHalfSumm = 0;
        int halfIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            firstHalfSumm += arr[i];
            if (firstHalfSumm >= (sumArr / 2)) {
                halfIndex = i;
                firstHalfSumm -= arr[i];
                break;
            }
        }
        for (int i = arr.length - 1; i > halfIndex; i--) {
            secondHalfSumm += arr[i];
        }
        if (firstHalfSumm == secondHalfSumm) return halfIndex;
        return -1;
    }


}
