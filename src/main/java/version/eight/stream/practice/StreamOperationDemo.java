package version.eight.stream.practice;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperationDemo {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("jhon", "martin", "mary", "Steve");
        /*stringList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Stream creation

        Stream s = Stream.empty(); //empty stream, return zero stream

        //Stream.of()

        Stream streamArray = Stream.of("x", "y", "z");

        //Stream.generate()

              Stream<Integer> intStream = Stream.generate(() -> 1).limit(5);
              intStream.forEach(System.out::println);

         //Stream.iterate()

        Stream<Integer> integerStream = Stream.iterate(100, n -> n + 1).limit(5);
        integerStream.forEach(System.out::println);*/


/*
       Stream<String> names = stringList.stream().map(String::toUpperCase)
               .peek(System.out::println)
               .filter(s1 -> s1.startsWith("J"));


        System.out.println("Calling terminal operation: count");
        long count = names.count();

        System.out.println("Count: "+count);

        int sum = Arrays.stream(new int[] {1,2,3}).sum();

        System.out.println(sum);


        Stream.of("10", "20", "30")
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);


        String collect = IntStream.of(10, 20, 30)
                .mapToObj(n -> ""+n)
                .collect(Collectors.joining("-"));
        System.out.println(collect);
*/


        record Employee(String name, int age, List<String> listOfCities) implements  Comparable<Employee> {
            public Employee(String name, int age,List<String> listOfCities) {
                this.name = name;
                this.age = age;
                this.listOfCities=listOfCities;
            }
            @Override
            public int compareTo(Employee o) {
                return name.compareTo(o.name);
            }
        }

        List<Employee> listOfEmployees = new ArrayList<>();

        Employee e1 = new Employee("Mohan", 24,Arrays.asList("Newyork","Banglore"));
        Employee e2 = new Employee("John", 27,Arrays.asList("Paris","London"));
        Employee e3 = new Employee("Vaibhav", 32,Arrays.asList("Pune","Seattle"));
        Employee e4 = new Employee("Amit", 22,Arrays.asList("Chennai","Hyderabad"));

        listOfEmployees.add(e1);
        listOfEmployees.add(e2);
        listOfEmployees.add(e3);
        listOfEmployees.add(e4);

        System.out.println("\n__________________Sorted with Comparable________________________________________\n");

        List<Employee> employees = listOfEmployees.stream()
                .sorted()
                .collect(Collectors.toList());

      /*  List<Employee> employeeses = listOfEmployees.stream()
                .sorted()
                        .toList();*/
        System.out.println(employees);

        System.out.println("\n__________________Sorted with Comparator________________________________________\n");

        List<Employee> employees1 = listOfEmployees.stream()
                .sorted((v1,v2) -> v1.age - v2.age)
                .collect(Collectors.toList());

        System.out.println(employees1);
        System.out.println("\n__________________Min Age________________________________________\n");
   listOfEmployees.stream()
           .reduce((b1, b2) -> (b1.age < b2.age ? b1:b2))
           .ifPresent(System.out::println);

        System.out.println("\n__________________Some of age of all employees________________________________________\n");
       int sumAges =  listOfEmployees.stream()
                .mapToInt(Employee::age)
                .reduce(0, (age1, age2) -> (age1 + age2));

        System.out.println("Sum of All Ages " + sumAges);

        System.out.println("\n__________________Mininum age of employee________________________________________\n");
        Optional<Employee> minEmpOpt = listOfEmployees.stream()
                .min(Comparator.comparing(Employee::age));

        System.out.println(minEmpOpt.get().age);





    }


}
