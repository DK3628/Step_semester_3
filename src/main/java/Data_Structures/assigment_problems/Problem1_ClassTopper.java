/**
 * Problem 1: Class Topper Finder.
 *
 * Time complexity : O(m * n) - m students, n subjects; every mark is read once.
 * Extra space     : O(1)     - only the best row, best total and a running sum.
 */
public class Problem1_ClassTopper {

    public static class Result {
        public final int rowIndex, total;
        Result(int rowIndex, int total) { this.rowIndex = rowIndex; this.total = total; }
        @Override public String toString() { return "(" + rowIndex + ", " + total + ")"; }
    }

    public static Result findTopper(int[][] marks) {
        int bestRow = -1, bestTotal = -1;
        for (int i = 0; i < marks.length; i++) {
            int total = 0;
            for (int mark : marks[i]) total += mark;
            if (total > bestTotal) {          // strictly greater: ties keep the smaller row index
                bestTotal = total;
                bestRow = i;
            }
        }
        return new Result(bestRow, bestTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {{78, 85, 90}, {88, 92, 79}, {65, 70, 95}};
        System.out.println(findTopper(marks));                                   // (1, 259)
        System.out.println(findTopper(new int[][]{{50, 50}, {60, 40}, {10, 10}})); // (0, 100) tie -> smallest row
        System.out.println(findTopper(new int[][]{{0, 0, 0}}));                  // (0, 0)
    }
}
