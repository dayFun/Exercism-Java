import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Pangrams {

    public static final int LETTERS_IN_ENGLISH_ALPHABET = 26;

    public static boolean isPangram(String candidateString) {
        Set<String> letters = Arrays.asList(candidateString.toLowerCase()
                                                           .replaceAll("\\p{Punct}|[^a-z]|\\s", "")
                                                           .split(""))
                                    .stream()
                                    .collect(toSet());

        return letters.size() == LETTERS_IN_ENGLISH_ALPHABET;
    }
}
