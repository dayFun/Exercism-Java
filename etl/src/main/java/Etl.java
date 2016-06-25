import java.util.*;
import java.util.stream.Collectors;

public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> tiles = new HashMap<>();
        for(Integer key : old.keySet()){
            List<String> letters = old.get(key);
            for(String letter : letters) {
                tiles.put(letter.toLowerCase(), key);
            }
        }
        return tiles;
    }
}
