import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNA {

    private static final char ADENINE = 'A';
    private static final char CYTOSINE = 'C';
    private static final char GUANINE = 'G';
    private static final char THYMINE = 'T';

    private static final List<Character> NUCLEOTIDES = Arrays.asList(ADENINE, CYTOSINE, GUANINE, THYMINE);

    private final String dnaString;

    public DNA(final String dnaString) {
        this.dnaString = dnaString;
    }

    public Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> dnaMap = initDnaMap();

        NUCLEOTIDES.forEach(nucleotide -> dnaMap.put(nucleotide, count(nucleotide)));

        return dnaMap;
    }

    public int count(char nucleotide) {
        if (!NUCLEOTIDES.contains(nucleotide)) {
            throw new IllegalArgumentException();
        }

        int total = 0;
        for (int i = 0; i < dnaString.length(); i++) {
            if (dnaString.charAt(i) == nucleotide) {
                total++;
            }
        }
        return total;
    }

    private Map<Character, Integer> initDnaMap() {
        Map<Character, Integer> dnaMap = new HashMap<>();
        dnaMap.put(ADENINE, 0);
        dnaMap.put(CYTOSINE, 0);
        dnaMap.put(GUANINE, 0);
        dnaMap.put(THYMINE, 0);

        return dnaMap;
    }
}
