package other;



public class ReverseInt {

    public static int reverse(int x) {
        if (x >= 0) {
            return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
        } else {
            return Integer.parseInt(new StringBuilder(String.valueOf(x).substring(1)).reverse().toString()) * -1;
        }
    }

}
