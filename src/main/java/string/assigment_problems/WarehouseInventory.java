public class WarehouseInventory {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0, sumB = 0;
        int maxQuantity = -1;
        String maxSection = "";
        int maxIndex = -1;
        
        for (int i = 0; i < sectionA.length; i++) {
            sumA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1; // 1-based indexing for output display
            }
        }
        
        for (int i = 0; i < sectionB.length; i++) {
            sumB += sectionB[i];
            // Uses >= to match item if it appears in section B as well (or > for strict first occurrence)
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }
        
        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";
        
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                sumA, sumB, status, maxQuantity, maxSection, maxIndex);
    }
    
    public static void main(String[] args) {
        int[] a = {20, 15, 30};
        int[] b = {25, 10, 30};
        System.out.println("sectionA={20,15,30}, sectionB={25,10,30}");
        analyzeInventory(a, b);
    }
}