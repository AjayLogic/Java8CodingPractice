package version.eleven.features;

import java.util.Optional;

public class OptionalUpdates {

    // isEmpty()

    public static void main(String[] args) {
        Optional<String> str = Optional.empty();

        System.out.println(str.isEmpty());
        System.out.println(str.isPresent());
    }
}
