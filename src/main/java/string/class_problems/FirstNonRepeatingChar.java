import java.util.HashMap;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : text.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c : text.toCharArray()) {
            if (counts.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String[] tests = {"swiss", "aabbcc"};
        for (String test : tests) {
            char result = findFirstNonRepeatingChar(test);
            if (result == '\0') {
                System.out.printf("\"%s\" No Non-Repeating Character Found\n", test);
            } else {
                System.out.printf("\"%s\" First Non-Repeating Character: '%c'\n", test, result);
            }
        }
    }
}