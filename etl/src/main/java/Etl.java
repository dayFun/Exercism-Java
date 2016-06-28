import rx.Observable;
import rx.functions.Func1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {

    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> tileValues = new HashMap<>();

        Observable.from(old.entrySet()).subscribe(entry -> {
            entry.getValue().forEach(letter -> {
                tileValues.put(letter.toLowerCase(), entry.getKey());
            });
        });

        return tileValues;
    }

}
