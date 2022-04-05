package coding.practice.string;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StringManipulation {


    public static void main(String[] args) {

        //System.out.println(reverseWords("I like reading books"));

        //System.out.println(containsOnlyDigits("123hello4"));

        //System.out.println(checkVowelAndConsonants("Ajayei"));

        //System.out.println(countOccuracneOfCertainCharacter("ajaysingh", 's'));

        //System.out.println(removingGivenChar("ajay", 'a'));

        System.out.println(maxOccuranceJava8("ajaysinghsuny"));
    }

    /*
    Count duplicate character in given String
    */
    public static Map<Character, Integer> countDuplicateCharacter(String str) {

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k,v) -> (v == null) ? 1 : ++v);

        }
        return result;
    }

    /*
    Count duplicate character in given String with Approach 2
    */
    public static Map<Character, Long> countDuplicateCharacterApproach2(String str) {
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting()));
        return result;
    }

    /*
   Reverse word
   */
    public static String reverseWords(String s) {
        Pattern PATTERN = Pattern.compile(" ");
        return PATTERN.splitAsStream(s)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));

    }

    public static boolean containsOnlyDigits(String str) {
        return str.chars()
                .allMatch(Character::isDigit);
    }


    public static Map<Long, Long> checkVowelAndConsonants(String str) {

         Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i','o', 'u'));

         str = str.toLowerCase(Locale.ROOT);
         long vowel = str.chars()
                 .filter(c -> allVowels.contains((char)c))
                 .count();
        long consonats = str.chars()
                .filter(c -> !allVowels.contains((char)c))
                .filter(ch -> (ch >= 'a' && ch <='z'))
                .count();
        return Map.of(vowel, consonats);
    }

    public static int countOccuracneOfCertainCharacter(String str, char ch) {

        return str.length() - str.replace(String.valueOf(ch), "").length();
    }


    public static boolean isPelindrome(String str) {
        int left = 0;
        int right = str.length()-1;
        while(right > left) {
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPelindromeUsingStringBuilder(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static String removingDuplicates(String str) {

        return Arrays.stream(str.split(""))
                .distinct()
                .collect(Collectors.joining());
    }

    public static String removingGivenChar(String s, char c) {
        return Arrays.stream(s.split(""))
                .filter(ch -> !ch.equals(String.valueOf(c)))
                .collect(Collectors.joining());
    }

    public static Map<Character, Integer> maxOccurance(String str) {

        Map<Character, Integer> counter = new HashMap<>();
        char[] chStr = str.toCharArray();
        for(int i = 0 ; i< chStr.length; i++) {
            char ch = chStr[i];
            if(!Character.isWhitespace(ch)) {
                Integer noCh = counter.get(ch);
                if(noCh == null){
                    counter.put(ch,1);
                } else {
                    counter.put(ch, ++noCh);
                }
            }
        }

        int maxOccurances = Collections.max(counter.values());
        char maxCharacter = Character.MIN_VALUE;

        for(Map.Entry<Character, Integer> entry:counter.entrySet()) {
            if(entry.getValue() == maxOccurances) {
                maxCharacter = entry.getKey();
            }
        }
        return Map.of(maxCharacter, maxOccurances);
    }

    public static Map<Character, Long> maxOccuranceJava8(String str) {

        return str.chars()
                .filter(ch -> !Character.isWhitespace(ch))
                .mapToObj(c -> (char)c)
                .collect(groupingBy(c -> c, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(p -> Map.of(p.getKey(), p.getValue()))
                .orElse(Map.of(Character.MIN_VALUE, -1L));
    }

}
