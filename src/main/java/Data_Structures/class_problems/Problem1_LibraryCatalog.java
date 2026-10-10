/**
 * Problem 1: Library Catalog Lookup (binary search on a sorted catalog).
 *
 * Time complexity : O(log n)  - the search range is halved on every step.
 * Extra space     : O(1)      - iterative version uses only a few index variables.
 */
public class Problem1_LibraryCatalog {

    /** catalog[i] = {isbn, title}, sorted ascending by ISBN. */
    public static String findBook(String[][] catalog, String targetIsbn) {
        if (catalog == null || targetIsbn == null) return "Not Found";
        int low = 0, high = catalog.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;          // avoids int overflow
            int cmp = compareIsbn(catalog[mid][0], targetIsbn);
            if (cmp == 0) return catalog[mid][1];
            if (cmp < 0) low = mid + 1;                 // target is in the right half
            else high = mid - 1;                        // target is in the left half
        }
        return "Not Found";
    }

    /** Numeric-string comparison: shorter string = smaller number, else lexicographic. */
    private static int compareIsbn(String a, String b) {
        if (a.length() != b.length()) return Integer.compare(a.length(), b.length());
        return a.compareTo(b);
    }

    public static void main(String[] args) {
        String[][] catalog = {
            {"0001112223", "Introduction to Algebra"},
            {"0002223334", "Beginning Python"},
            {"0003334445", "Classic Mythology"},
            {"0004445556", "Data and Society"},
            {"0005556667", "European History"}
        };
        System.out.println(findBook(catalog, "0003334445"));            // Classic Mythology
        System.out.println(findBook(catalog, "0009998887"));            // Not Found
        System.out.println(findBook(catalog, "0001112223"));            // first element
        System.out.println(findBook(catalog, "0005556667"));            // last element
        System.out.println(findBook(new String[0][], "0001112223"));    // empty catalog
    }
}
