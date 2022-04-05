package version.eleven.features;

import java.util.stream.Collectors;

public class StringUpdates {
    //isBlank()
    //lines()
    //strip(), remove black space for unicode character as well
    //stripLeading(), stripTrailing()
    //repeat()
    public static void main(String[] args) {
        String str = "   ";

        System.out.println(str.isBlank());

        str = "I\nam\nthe creator of my destiny";
        System.out.println(str.lines().collect(Collectors.toList()));

        System.out.println("-".repeat(10));

    }
}
