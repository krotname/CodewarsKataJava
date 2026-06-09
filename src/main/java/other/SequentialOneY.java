package other;

public class SequentialOneY {
    static int maxConsecutiveOnes(String line) {
        if (line == null || line.isEmpty()) {
            return 0;
        }

        var count = 0;
        var maxCount = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '1') {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }
}
