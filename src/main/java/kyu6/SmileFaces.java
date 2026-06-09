package kyu6;


import java.util.List;
import java.util.Set;


public class SmileFaces {

    private static final Set<String> SMILE_FACES = Set.of(
            ":)", ":D", ":-)", ":-D", ":~)", ":~D",
            ";)", ";D", ";-)", ";-D", ";~)", ";~D");

    public static int countSmileys(List<String> arr) {
        return (int) arr.stream().filter(SMILE_FACES::contains).count();
    }





}
