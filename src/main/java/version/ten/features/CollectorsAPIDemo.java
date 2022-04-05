package version.ten.features;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsAPIDemo {

    public static void main(String[] args) {
        List<Integer> list = List.of(15,20, 30, 17);

        List<Integer> listMultiple  = list.stream().filter(i -> i%3==0).collect(Collectors.toUnmodifiableList());
    }
}
