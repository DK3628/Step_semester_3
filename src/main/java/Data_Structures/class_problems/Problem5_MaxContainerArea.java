/**
 * Problem 5: Maximize Area Between Two Boundaries (Container With Most Water).
 *
 * Brute force (every pair): Time O(n^2), Space O(1)
 * Two pointers (optimal):   Time O(n),   Space O(1)
 *
 * Why two pointers works: start with the widest container. The area is limited by the
 * SHORTER wall, so moving the taller wall inward can only shrink the width without any
 * chance of a higher limit - it can never help. Moving the shorter wall inward is the only
 * move that might find a taller limit, so we discard the shorter wall each step.
 * That rules out many pairs at a time, so every index is visited at most once.
 * For very large n (e.g. 10^6) O(n^2) is ~10^12 operations (infeasible) vs ~10^6.
 */
public class Problem5_MaxContainerArea {

    public static long bruteForce(int[] heights) {
        long best = 0;
        for (int i = 0; i < heights.length; i++)
            for (int j = i + 1; j < heights.length; j++)
                best = Math.max(best, (long) Math.min(heights[i], heights[j]) * (j - i));
        return best;
    }

    public static long maxContainerArea(int[] heights) {
        long best = 0;
        int left = 0, right = heights.length - 1;
        while (left < right) {
            long area = (long) Math.min(heights[left], heights[right]) * (right - left);
            best = Math.max(best, area);
            if (heights[left] < heights[right]) left++;   // move the shorter wall
            else right--;
        }
        return best;
    }

    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(h) + " (brute force: " + bruteForce(h) + ")");   // 49
        System.out.println(maxContainerArea(new int[]{1, 1}));          // 1
        System.out.println(maxContainerArea(new int[]{4, 3, 2, 1, 4})); // 16
        System.out.println(maxContainerArea(new int[]{5}));             // 0
    }
}
