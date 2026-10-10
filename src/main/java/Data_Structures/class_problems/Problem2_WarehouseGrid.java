/**
 * Problem 2: Warehouse Grid Summary.
 *
 * Time complexity : O(m * n) - every cell is visited exactly once.
 * Extra space     : O(1)     - only a total, a max value and two coordinates.
 */
public class Problem2_WarehouseGrid {

    public static class Summary {
        public final long totalItems;
        public final int row, col;
        Summary(long totalItems, int row, int col) { this.totalItems = totalItems; this.row = row; this.col = col; }
        @Override public String toString() { return "(" + totalItems + ", (" + row + ", " + col + "))"; }
    }

    public static Summary warehouseSummary(int[][] grid) {
        long total = 0;
        int max = -1, maxRow = -1, maxCol = -1;
        if (grid != null) {
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    total += grid[r][c];
                    if (grid[r][c] > max) {            // strict '>' keeps the FIRST maximum
                        max = grid[r][c];
                        maxRow = r;
                        maxCol = c;
                    }
                }
            }
        }
        return new Summary(total, maxRow, maxCol);     // (0, (-1,-1)) for an empty grid
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 9, 2}, {7, 1, 6}, {3, 12, 5}};
        System.out.println(warehouseSummary(grid));                      // (49, (2, 1))
        System.out.println(warehouseSummary(new int[][]{{5, 5}, {5, 5}})); // (20, (0, 0)) tie -> first
        System.out.println(warehouseSummary(new int[][]{}));              // (0, (-1, -1))
    }
}
