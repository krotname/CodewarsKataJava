package algorithms.sprint0;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long sum = sum(a, b);
        System.out.println(sum);
    }

    public static long sum(int a, int b) {
        return (long) a + b;
    }
}
