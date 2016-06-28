import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class Etl {

    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> tileValues = new HashMap<>();

        old.forEach((value, letters) -> letters.stream()
                                               .forEach(tile -> tileValues.put(tile.toLowerCase(), value)));

        return tileValues;
    }

}
