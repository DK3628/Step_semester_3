import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem 4: Pair With Target Sum (unsorted array).
 *
 * Approach 1 - Brute force (all pairs):        Time O(n^2)       Space O(1)
 * Approach 2 - Hash set (complement lookup):   Time O(n) average Space O(n)
 * Approach 3 - Sort + two pointers:            Time O(n log n)   Space O(1) extra
 *              (on a copy it is O(n); in-place sorting alters the input order)
 *
 * Trade-offs: hashing is fastest but uses memory; sorting + two pointers is a good
 * middle ground when memory matters; brute force is simplest but slowest.
 */
public class Problem4_PairWithSumArray {

    public static boolean bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if ((long) nums[i] + nums[j] == target) return true;
        return false;
    }

    public static boolean usingHashSet(int[] nums, int target) {
        Set<Long> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains((long) target - x)) return true;
            seen.add((long) x);
        }
        return false;
    }

    public static boolean usingSortAndTwoPointers(int[] nums, int target) {
        int[] a = nums.clone();             // keep the caller's array unchanged
        Arrays.sort(a);
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {                   // lo < hi guarantees two distinct positions
            long sum = (long) a[lo] + a[hi];
            if (sum == target) return true;
            if (sum < target) lo++; else hi--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15}, b = {3, 4, 6}, c = {5, 5}, d = {-4, 10, -6, 2};
        System.out.println(bruteForce(a, 9) + " " + usingHashSet(a, 9) + " " + usingSortAndTwoPointers(a, 9));      // true
        System.out.println(bruteForce(b, 20) + " " + usingHashSet(b, 20) + " " + usingSortAndTwoPointers(b, 20));   // false
        System.out.println(bruteForce(c, 10) + " " + usingHashSet(c, 10) + " " + usingSortAndTwoPointers(c, 10));   // true (duplicates)
        System.out.println(bruteForce(d, -10) + " " + usingHashSet(d, -10) + " " + usingSortAndTwoPointers(d, -10)); // true (-4 + -6)
    }
}
