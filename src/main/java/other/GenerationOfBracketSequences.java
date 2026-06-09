package other;

import java.util.ArrayList;
import java.util.List;

public class GenerationOfBracketSequences {

    static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        recursiveGenerate(result, "", 0, 0, n);
        return result;
    }

    private static void recursiveGenerate(List<String> result, String current, int open, int closed, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) {
            recursiveGenerate(result, current + "(", open + 1, closed, n);
        }
        if (closed < open) {
            recursiveGenerate(result, current + ")", open, closed + 1, n);
        }
    }
}
