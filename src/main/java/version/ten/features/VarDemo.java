package version.ten.features;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class VarDemo {

    //Can't use var for instance variable
    // can't assign null to var
    // can't assign lambda expression to var

    public static void main(String[] args) {
        var var = 10;
        var map = new HashMap<String, List<String>>();
        for(var entry : map.entrySet()) {

        }

        Consumer<Integer> x = System.out::println;
    }
}
