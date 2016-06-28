import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.junit.Assert.assertFalse;

public class ToMapTest {


    private Puppy henry;
    private Puppy danae;
    private Puppy luther;
    private List<Puppy> puppyList;

    @Before
    public void setUp() throws Exception {
        henry = new Puppy("henry", 3);
        danae = new Puppy("danae", 4);
        luther = new Puppy("luther", 2);
        puppyList = Arrays.asList(henry, danae, luther);
    }

    @Test
    public void testToMapFromList() throws Exception {
        Map<String, Integer> map = puppyList.stream()
                .collect(Collectors.toMap(Puppy::getName, Puppy::getAge));

        assertThat(map, hasEntry("henry", 3));
        assertThat(map, hasEntry("danae", 4));
    }

    @Test
    public void testToMapFromMap() throws Exception {
        Map<String, List<Puppy>> familyPuppyMap = new HashMap<>();
        familyPuppyMap.put("Parents", Arrays.asList(luther));
        familyPuppyMap.put("St. Lunatics", Arrays.asList(henry, danae));


        List<String> puppies = familyPuppyMap.entrySet().stream()
                .flatMap(family -> family.getValue().stream())
                .map(Puppy::getName)
                .collect(Collectors.toList());


//        familyPuppyMap.values()
//                      .stream()
//                      .flatMap(List::stream)
//                      .collect(Collectors.gr))


    }

    class Puppy {
        private final String name;
        private final int age;

        Puppy(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "java8.collector.groupingBy.Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
