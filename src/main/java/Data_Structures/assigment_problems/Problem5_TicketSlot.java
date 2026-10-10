/**
 * Problem 5: Ticket Price Slot Finder.
 *
 * Linear scan:   Time O(n)      Space O(1)
 * Binary search: Time O(log n)  Space O(1)
 *
 * If the price is not found, the loop ends with low == the index where it belongs
 * (the count of prices smaller than newPrice).
 */
public class Problem5_TicketSlot {

    public static int findSlot(int[] prices, int newPrice) {
        int low = 0, high = prices.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prices[mid] == newPrice) return mid;
            if (prices[mid] < newPrice) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};
        System.out.println(findSlot(prices, 150));              // 1
        System.out.println(findSlot(prices, 210));              // 3
        System.out.println(findSlot(prices, 300));              // 4
        System.out.println(findSlot(prices, 100));              // 0
        System.out.println(findSlot(new int[]{}, 50));          // 0 (empty list)
    }
}
