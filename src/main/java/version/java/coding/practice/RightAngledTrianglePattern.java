package version.java.coding.practice;

import java.util.HashMap;

public class RightAngledTrianglePattern {

    public static void main(String[] args) {
        //printTriangle();

        charCounter();

    }

    public static void printTriangle() {
        int n = 7;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void charCounter(){
        String s = "I am the creator of my destiny!!";
        var map = new HashMap<Character, Integer>();

        int i = 0;
        while(i<s.length()) {
            char currentChar = s.charAt(i);
            if (!Character.isWhitespace(currentChar)) {
                if (map.containsKey(currentChar)) {
                    map.put(currentChar, map.get(currentChar) + 1);
                } else {
                    map.put(currentChar, 1);
                }
            }
            i++;
        }
        System.out.println(map);
    }
}
