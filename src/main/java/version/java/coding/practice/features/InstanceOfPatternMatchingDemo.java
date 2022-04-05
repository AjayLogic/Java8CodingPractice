package version.java.coding.practice.features;

public class InstanceOfPatternMatchingDemo {

    public static void main(String[] args) {

        Object object = get();
        if(object instanceof String str) { // no longer to typecast explicitly in java 14
            System.out.println(str);
        }

    }

    public static Object get () {
        return "Pattern matching in action";
    }
}
