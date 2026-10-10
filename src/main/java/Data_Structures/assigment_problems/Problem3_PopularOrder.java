import java.util.HashMap;
import java.util.Map;

/**
 * Problem 3: Most Popular Canteen Order.
 *
 * Re-scan counting (for each item, count its occurrences by scanning the whole list):
 *   Time O(n^2)   Space O(1)
 * Hash map (this solution):
 *   Time O(n) average (one pass to count + one pass to pick the winner)
 *   Space O(k), k = number of distinct items (at most n)
 */
public class Problem3_PopularOrder {

    public static class Result {
        public final String item;
        public final int count;
        Result(String item, int count) { this.item = item; this.count = count; }
        @Override public String toString() { return "(\"" + item + "\", " + count + ")"; }
    }

    public static Result mostPopular(String[] orders) {
        Map<String, Integer> counts = new HashMap<>();
        for (String item : orders) counts.merge(item, 1, Integer::sum);

        String bestItem = null;
        int bestCount = 0;
        for (String item : orders) {                       // original order => first-appearing tie wins
            int c = counts.get(item);
            if (c > bestCount) {                           // strictly greater
                bestCount = c;
                bestItem = item;
            }
        }
        return new Result(bestItem, bestCount);
    }

    public static void main(String[] args) {
        System.out.println(mostPopular(new String[]{"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"})); // ("dosa", 3)
        System.out.println(mostPopular(new String[]{"tea", "coffee", "coffee", "tea"}));                       // ("tea", 2)
        System.out.println(mostPopular(new String[]{"vada"}));                                                  // ("vada", 1)
    }
}
