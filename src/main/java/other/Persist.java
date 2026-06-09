package other;

// Выводит результат умножения цифр положительного числа в цикле, пока не останется однозначное число



public class Persist {


    public int persistence(long n) {
        int result = 0;
        while (n > 9) {
            char[] s = String.valueOf(n).toCharArray();
            int temp = Integer.parseInt(String.valueOf(s[0]));
            for (int i = 1; i < s.length; i++) {
                temp *= Integer.parseInt(String.valueOf(s[i]));
            }
            n = temp;
            result++;
        }
        return result;
    }
}
