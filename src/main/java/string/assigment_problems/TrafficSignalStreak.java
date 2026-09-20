public class TrafficSignalStreak {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) return;
        
        char maxChar = signalLog.charAt(0);
        int maxLen = 1;
        
        char currentChar = signalLog.charAt(0);
        int currentLen = 1;
        
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentLen++;
            } else {
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentLen = 1;
            }
        }
        // Check one last time at the end of the string
        if (currentLen > maxLen) {
            maxLen = currentLen;
            maxChar = currentChar;
        }
        
        System.out.printf("\"%s\" Longest Streak: '%c' repeated %d times\n", signalLog, maxChar, maxLen);
    }
    
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}