package kyu7;



public class DnaStrand {

    //7

    public static String makeComplement(String dna) {

        String result = dna.replace("A", "*");
        result = result.replace("T", "A");
        result = result.replace("*", "T");

        result = result.replace("C", "*");
        result = result.replace("G", "C");
        result = result.replace("*", "G");
        return result;
    }

    /**
     * Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions"
     * for the development and functioning of living organisms.
     * <p>
     * If you want to know more: http://en.wikipedia.org/wiki/DNA
     * <p>
     * In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G".
     * You have function with one side of the DNA (string, except for Haskell); you need to
     * get the other complementary side. DNA strand is never empty or there is no DNA at all.
     * <p>
     * More similar exercise are found here: http://rosalind.info/problems/list-view/ (source)
     * <p>
     * Example: (input: output)
     */

}
