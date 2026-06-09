package other;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.Comparator;



public class Compare {

    /**
     * Класс Compar представляет собой объект с двумя целочисленными полями a и b.
     * Реализует интерфейс Comparable для естественной сортировки по a, затем по b.
     */
    @Value
    @Builder
    public static class Compar implements Comparable<Compar> {
        int a;
        int b;

        @Override
        public int compareTo(Compar o) {
            return Comparator.comparingInt(Compar::getA)
                    .thenComparingInt(Compar::getB)
                    .compare(this, o);
        }
    }

    /**
     * Класс ComparComparator реализует Comparator для объектов Compar,
     * определяя порядок сортировки сначала по b, затем по a.
     */
    @Builder
    public static class ComparComparator implements Comparator<Compar>, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public int compare(Compar o1, Compar o2) {
            return Comparator.comparingInt(Compar::getB)
                    .thenComparingInt(Compar::getA)
                    .compare(o1, o2);
        }
    }


}
