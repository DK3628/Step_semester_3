/**
 * Problem 4: Hot Weather Alert Windows.
 *
 * Recalculating every block from scratch: Time O(n * k)   Space O(1)
 * Sliding window (this solution):         Time O(n)       Space O(1)
 *
 * The window sum is updated by adding the entering reading and subtracting the leaving one.
 * Comparing sum >= k * threshold avoids decimal division; long prevents overflow
 * (k * threshold can reach 10^5 * 10^4 = 10^9, close to the int limit for sums).
 */
public class Problem4_HotWeatherAlerts {

    public static int countAlerts(int[] readings, int k, int threshold) {
        long target = (long) k * threshold;
        long windowSum = 0;
        int alerts = 0;

        for (int i = 0; i < k; i++) windowSum += readings[i];   // first block
        if (windowSum >= target) alerts++;

        for (int i = k; i < readings.length; i++) {
            windowSum += readings[i] - readings[i - k];         // slide one hour forward
            if (windowSum >= target) alerts++;
        }
        return alerts;
    }

    public static void main(String[] args) {
        System.out.println(countAlerts(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4)); // 3
        System.out.println(countAlerts(new int[]{4, 4, 4}, 3, 4));                // 1 (average equals threshold)
        System.out.println(countAlerts(new int[]{1, 2, 3}, 1, 2));                // 2 (k = 1)
        System.out.println(countAlerts(new int[]{1, 1, 1, 1}, 4, 5));             // 0
    }
}
