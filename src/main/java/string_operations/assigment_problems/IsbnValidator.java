public class IsbnValidator {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed.toUpperCase();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        String norm = normalizeCode(code);
        
        if (norm.length() != 13) {
            return "Invalid: wrong length";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(norm.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(norm.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        String pubCode = norm.substring(0, 3);
        String year = norm.substring(3, 7);
        String catalog = norm.substring(7, 13);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ")
          .append(year).append(" | CATALOG: ").append(catalog);
          
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(" pen2026004251 "));
        System.out.println(validateAndFormat("12N2026004251"));
    }
}