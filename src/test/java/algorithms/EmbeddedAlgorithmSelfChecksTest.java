package algorithms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("unit")
class EmbeddedAlgorithmSelfChecksTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "algorithms.sprint1.Distances",
            "algorithms.sprint1.SleightOfHand",
            "algorithms.sprint1.Solution2",
            "algorithms.sprint2.Calculator",
            "algorithms.sprint2.Deque",
            "algorithms.sprint3.BrokenArray",
            "algorithms.sprint3.FastSort",
            "algorithms.sprint4.FindSystem",
            "algorithms.sprint5.PyramidSort",
            "algorithms.sprint6.DorogayaSet",
            "algorithms.sprint6.WaterWorld",
            "algorithms.sprint7.EqualSums",
            "algorithms.sprint7.LevenshteinDistance",
            "algorithms.sprint8.Crib",
            "algorithms.sprint8.PackedPrefix"
    })
    void embeddedSelfCheckPasses(String className) throws Exception {
        Method selfCheck = Class.forName(className).getDeclaredMethod("test");
        selfCheck.setAccessible(true);

        try {
            selfCheck.invoke(null);
        } catch (InvocationTargetException exception) {
            throwOriginalCause(exception.getCause());
        }
    }

    private static void throwOriginalCause(Throwable cause) throws Exception {
        if (cause instanceof Exception exception) {
            throw exception;
        }
        if (cause instanceof Error error) {
            throw error;
        }
        throw new AssertionError(cause);
    }
}
