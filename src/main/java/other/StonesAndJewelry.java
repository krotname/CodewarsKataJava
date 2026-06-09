package other;


import java.util.stream.Collectors;


public class StonesAndJewelry {

    public int calculate(String jewelry, String stones) {
        if (jewelry == null || stones == null || jewelry.isEmpty() || stones.isEmpty()) {
            return 0;
        }

        var setJewelry = jewelry
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        char[] stonesChars = stones.toCharArray();
        int count = 0;
        for (char stonesChar : stonesChars) {
            if (setJewelry.contains(stonesChar)) {
                count++;
            }
        }
        return count;
    }
}
