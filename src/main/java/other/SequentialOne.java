package other;



public class SequentialOne {

    public int calculate(String integers) {
        if (integers == null || integers.isEmpty()) {
            return 0;
        }

        var count = 0;
        var maxCount = 0;

        for (int i = 0; i < integers.length(); i++) {
            if (integers.charAt(i) == '1') {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }
}
