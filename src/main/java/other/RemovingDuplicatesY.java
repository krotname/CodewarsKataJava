package other;

import java.util.OptionalDouble;

public class RemovingDuplicatesY {
    private static final Deduplicator DEDUPLICATOR = new Deduplicator();

    public static OptionalDouble calc(double input) {
        return DEDUPLICATOR.calc(input);
    }

    static void reset() {
        DEDUPLICATOR.reset();
    }

    static final class Deduplicator {
        private Double previous;

        OptionalDouble calc(double input) {
            if (previous == null || Double.compare(input, previous) != 0) {
                previous = input;
                return OptionalDouble.of(input);
            }
            return OptionalDouble.empty();
        }

        void reset() {
            previous = null;
        }
    }

}
