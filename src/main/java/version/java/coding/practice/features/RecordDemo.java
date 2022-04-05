package version.java.coding.practice.features;

public class RecordDemo {

    record Employee(String name, int sal) {
        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", sal=" + sal +
                    '}';
        }
    }
    public static void main(String[] args) {

        Employee employee = new Employee("jhon", 10000);
        System.out.println(employee);

    }
}
