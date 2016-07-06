import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class WordCount {


    public Map<String, Integer> phrase(String phrase) {
        String format = phrase.replaceAll("\\p{Punct}", "").toLowerCase();
        List<String> words = Arrays.asList(format.split("\\s+"));

        return words.stream()
                    .collect(toMap(Function.identity(),
                            s -> 1,
                            (integer, integer2) -> ++integer));
    }
}
