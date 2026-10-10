import java.util.Arrays;

/**
 * Problem 2: Merging Two Token Queues.
 *
 * Two-pointer merge:  Time O(m + n)   Space O(m + n) for the output list (O(1) extra beyond it).
 * Join + sort:        Time O((m + n) log(m + n))  Space O(m + n)
 *   -> the merge is faster because it exploits the existing order instead of re-sorting from scratch.
 */
public class Problem2_MergeTokens {

    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        int[] result = new int[counterA.length + counterB.length];
        int i = 0, j = 0, k = 0;
        while (i < counterA.length && j < counterB.length) {
            if (counterA[i] <= counterB[j]) result[k++] = counterA[i++];   // <= keeps duplicates, stable
            else result[k++] = counterB[j++];
        }
        while (i < counterA.length) result[k++] = counterA[i++];           // leftovers from A
        while (j < counterB.length) result[k++] = counterB[j++];           // leftovers from B
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeTokens(new int[]{3, 8, 15, 20}, new int[]{5, 8, 12}))); // [3, 5, 8, 8, 12, 15, 20]
        System.out.println(Arrays.toString(mergeTokens(new int[]{}, new int[]{4, 9})));                  // [4, 9]
        System.out.println(Arrays.toString(mergeTokens(new int[]{1, 2}, new int[]{})));                  // [1, 2]
        System.out.println(Arrays.toString(mergeTokens(new int[]{}, new int[]{})));                      // []
    }
}
