package other;

public class StonesAndJewelryE {

    static int countJewels(String jewelry, String stones) {
        if (jewelry == null || stones == null || jewelry.isEmpty() || stones.isEmpty()) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < stones.length(); ++i) {
            char ch = stones.charAt(i);
            if (jewelry.indexOf(ch) >= 0) {
                ++result;
            }
        }

        return result;
    }
}
