public class MovieReviewProfiler {
    public static void classifyWordLengths(String review) {
        int shortCount = 0, mediumCount = 0, longCount = 0;
        String[] words = review.split("\\s+");
        
        for (String word : words) {
            // Strip out non-alphabetic characters to accurately count word length
            String cleanWord = word.replaceAll("[^a-zA-Z]", ""); 
            int len = cleanWord.length();
            if (len == 0) continue;
            
            if (len <= 4) {
                shortCount++;
            } else if (len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }
        
        System.out.println("\"" + review + "\"");
        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }
    
    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}