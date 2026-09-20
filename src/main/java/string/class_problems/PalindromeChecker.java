public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        return text.equals(new String(arr));
    }

    public static void main(String[] args) {
        String[] tests = {"madam", "hello"};
        for (String test : tests) {
            boolean it = isPalindromeIterative(test);
            boolean rec = isPalindromeRecursive(test);
            boolean arr = isPalindromeArrayReversal(test);
            
            String itStr = it ? "Palindrome" : "Not Palindrome";
            String recStr = rec ? "Palindrome" : "Not Palindrome";
            String arrStr = arr ? "Palindrome" : "Not Palindrome";
            
            System.out.printf("\"%s\" Iterative: %s | Recursive: %s | Array Reversal: %s\n", test, itStr, recStr, arrStr);
        }
    }
}