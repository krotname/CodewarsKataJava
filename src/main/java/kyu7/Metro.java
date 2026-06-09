package kyu7;


import java.util.List;


public class Metro {

    //6 https://www.codewars.com/kata/5648b12ce68d9daa6b000099/solutions/java

    public static int countPassengers(List<int[]> stops) {
        if (stops == null || stops.isEmpty()) {
            return 0;
        }

        int passengers = 0;
        for (int[] stop : stops) {
            if (stop == null || stop.length != 2) {
                throw new IllegalArgumentException("each stop must contain on/off counts");
            }
            passengers += stop[0] - stop[1];
        }
        return passengers;
    }

}
