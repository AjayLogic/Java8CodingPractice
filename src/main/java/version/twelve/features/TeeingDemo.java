package version.twelve.features;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeeingDemo {
    public static void main(String[] args) {
        Result result = Stream.of(5, 10, 8, 20, 7).collect(Collectors.teeing(Collectors.counting(),
                Collectors.filtering(n -> Integer.parseInt(n.toString()) > 10,
                        Collectors.toList()), Result::new));

        System.out.println(result);
    }
}
