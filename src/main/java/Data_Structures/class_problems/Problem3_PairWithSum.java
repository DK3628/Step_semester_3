import java.util.HashSet;
import java.util.Set;

/**
 * Problem 3: Pair With Target Sum (unsorted). Two distinct elements (different indices).
 *
 * Approach 1 - Brute force (check every pair)
 *   Time: O(n^2)   Space: O(1)
 * Approach 2 - Hash set of seen values (check the complement)
 *   Time: O(n) average   Space: O(n)
 *
 * Trade-off: the hash set buys speed with extra memory. Brute force is fine for tiny
 * inputs or when memory is extremely tight; the hash set is preferred otherwise.
 */
public class Problem3_PairWithSum {

    public static boolean hasPairBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if ((long) nums[i] + nums[j] == target) return true;
        return false;
    }

    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Long> seen = new HashSet<>();
        for (int x : nums) {
            long complement = (long) target - x;
            if (seen.contains(complement)) return true;   // complement came from an EARLIER index
            seen.add((long) x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] tests  = {{2, 7, 11, 15}, {3, 4, 6}, {5}, {3, 3}, {-3, 4, 1}, {4, 1}};
        int[] targets  = {9, 20, 10, 6, -2, 8};
        for (int i = 0; i < tests.length; i++) {
            System.out.println("target=" + targets[i]
                + "  brute=" + hasPairBruteForce(tests[i], targets[i])
                + "  hash=" + hasPairWithSum(tests[i], targets[i]));
        }
        // expected: true/true, false/false, false (single element), true ([3,3] duplicates),
        //           true (-3+1=-2), false
    }
}
