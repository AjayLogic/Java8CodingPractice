package version.eight.lambda;

import java.util.Arrays;
import java.util.function.*;

public class LambdaPractice {
    public static void main(String[] args) {
        Supplier<Double> random = Math::random;
        System.out.println(random.get());

        Consumer<Integer> print = System.out::println;

        print.accept(10);

        Predicate<String> test = String::isEmpty;

        System.out.println(test.test(""));

        Function<String, Integer> stringLength = String::length;
        System.out.println(stringLength.apply("Hello"));

        BiConsumer<String, Integer> biConsumer = (s, i) -> {
            System.out.println("my name is " +s + "My age is "+i);
        };

        biConsumer.accept("Ajay", 33);

        String[] fruits = { "apple", "cherries", "banana", "avocado" };
        Arrays.sort(fruits, (fruit1, fruit2) ->- fruit1.compareTo(fruit2));
        System.out.println(Arrays.toString(fruits));


    }
}
