public class BankTransactionValidator {
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed.toUpperCase();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        String norm = normalizeReference(reference);
        
        if (norm.length() != 14) {
            return "Invalid: wrong length";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(norm.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(norm.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        String bankCode = norm.substring(0, 3);
        String dateStr = norm.substring(3, 9);
        String seq = norm.substring(9, 14);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(dateStr.substring(0, 2)).append("/")
          .append(dateStr.substring(2, 4)).append("/")
          .append(dateStr.substring(4, 6)).append(" | SEQ: ")
          .append(seq);
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(validateAndFormat(" hdf03022600042 "));
        System.out.println(validateAndFormat("12F03022600042"));
    }
}