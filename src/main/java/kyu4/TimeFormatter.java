package kyu4;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {

    // 4 https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java

    /**
     * Your task in order to complete this Kata is to write a function which formats a duration, given as a number
     * of seconds, in a human-friendly way.
     * <p>
     * The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration
     * is expressed as a combination of years, days, hours, minutes and seconds.
     * <p>
     * It is much easier to understand with an example:
     * <p>
     * TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
     * TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"
     * For the purpose of this Kata, a year is 365 days and a day is 24 hours.
     * <p>
     * Note that spaces are important.
     * <p>
     * Detailed rules
     * The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer
     * and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.
     * <p>
     * The components are separated by a comma and a space (", "). Except the last component, which is separated
     * by " and ", just like it would be written in English.
     * <p>
     * A more significant units of time will occur before than a least significant one. Therefore, 1 second and
     * 1 year is not correct, but 1 year and 1 second is.
     * <p>
     * Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
     * <p>
     * A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid,
     * but it should be just 1 minute.
     * <p>
     * A unit of time must be used "as much as possible". It means that the function should not return 61 seconds,
     * but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than
     * any valid more significant unit of time.
     */

    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTE;
    private static final int SECONDS_IN_DAY = 24 * SECONDS_IN_HOUR;
    private static final int SECONDS_IN_YEAR = 365 * SECONDS_IN_DAY;

    public static String formatDuration(int seconds) {
        if (seconds <= 0) {
            return "now";
        }

        List<String> parts = new ArrayList<>();
        int remainingSeconds = seconds;
        remainingSeconds = addComponent(parts, remainingSeconds, SECONDS_IN_YEAR, "year");
        remainingSeconds = addComponent(parts, remainingSeconds, SECONDS_IN_DAY, "day");
        remainingSeconds = addComponent(parts, remainingSeconds, SECONDS_IN_HOUR, "hour");
        remainingSeconds = addComponent(parts, remainingSeconds, SECONDS_IN_MINUTE, "minute");
        addComponent(parts, remainingSeconds, 1, "second");

        return joinHumanReadable(parts);
    }

    private static int addComponent(List<String> parts, int remainingSeconds, int unitSeconds, String unitName) {
        int value = remainingSeconds / unitSeconds;
        if (value > 0) {
            parts.add(value + " " + unitName + (value == 1 ? "" : "s"));
        }
        return remainingSeconds % unitSeconds;
    }

    private static String joinHumanReadable(List<String> parts) {
        if (parts.size() == 1) {
            return parts.get(0);
        }
        return String.join(", ", parts.subList(0, parts.size() - 1)) + " and " + parts.get(parts.size() - 1);
    }
}
