import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//    Map<Integer, String> numbers;
//    numbers = new HashMap<>();
//    numbers.put(1, "one");
//    numbers.put(30, "thirty");
//    numbers.put(50, "fifty");
//    numbers.put(1000000, "one million");
//    numbers.put(69, "sixty nine");
//
//    for(Map.Entry<Integer, String> entry: numbers.entrySet()){
//        System.out.println(entry.getKey() + " is the key for " + entry.getValue());
//    }
//    }

        List<String> list;
        list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Stream<String> stream = list.stream().filter(s -> s.contains("e"));

        // anyMatch
        // allMatch (true for empty streams, since none do not match)
        // noneMatch (false for empty streams)
        boolean exists = list.stream().anyMatch(str->str.contains("ee"));
        System.out.println(exists);
    }
}


