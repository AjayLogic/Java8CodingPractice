package version.thread.creation.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class StringJoining {

    public static boolean isPrime(int number) {

        return number > 1 && IntStream.range(2, number)
                .noneMatch(i -> number % i == 0 );
    }
    public static void main(String[] args) {
        IntStream.range(1, 8)
                .forEach( i -> System.out.printf("isPrime(%d) ? %b\n", i,  isPrime(i)));


        Map<String, Integer> scores = new HashMap<>();
        scores.put("Jack", 12);
        scores.put("Jill", 15);
        scores.put("Tom", 11);
        scores.put("Darla", 15);

        Map<Integer, List<String>> result = scores.keySet()
                .stream()
                .collect(groupingBy(scores::get));
        System.out.println(result);
    }
}
