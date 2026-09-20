public class TypingAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int matches = 0;
        int len = Math.min(original.length(), typed.length());
        int firstMismatch = -1;
        char expected = ' ', actual = ' ';
        
        for (int i = 0; i < len; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatch == -1) {
                firstMismatch = i + 1; // 1-based index for position
                expected = original.charAt(i);
                actual = typed.charAt(i);
            }
        }
        
        double accuracy = ((double) matches / len) * 100;
        
        System.out.printf("original=\"%s\", typed=\"%s\"\n", original, typed);
        if (firstMismatch != -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n\n",
                    matches, len, accuracy, firstMismatch, expected, actual);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n\n", matches, len, accuracy);
        }
    }
    
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}