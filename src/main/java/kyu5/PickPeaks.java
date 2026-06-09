package kyu5;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class PickPeaks {

    private static final String POS = "pos";
    private static final String PEAKS = "peaks";

    /**
     * /\     /--\
     * \  /  \   /    \  (vector=true for rising, false for falling)
     *  \/    \_/
     */


    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> peaks = new LinkedHashMap<>();
        peaks.put(POS, new ArrayList<>());
        peaks.put(PEAKS, new ArrayList<>());
        if (arr == null || arr.length == 0) return peaks;
        boolean vector = false;
        int lastChangeVector = arr[0];
        int lastChangeVectorIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > lastChangeVector) {
                vector = true;
                lastChangeVector = arr[i];
                lastChangeVectorIndex = i;
            }
            if (arr[i] < lastChangeVector) {
                if (vector) {
                    peaks.get(POS).add(lastChangeVectorIndex);
                    peaks.get(PEAKS).add(lastChangeVector);
                }
                vector = false;
                lastChangeVector = arr[i];
                lastChangeVectorIndex = i;
            }
        }
        return peaks;
    }



}
