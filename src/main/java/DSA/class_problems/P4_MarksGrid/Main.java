import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = new ArrayList<>();
        List<int[]> rows = new ArrayList<>();

        for (String line; (line = in.readLine()) != null; ) {
            line = line.trim();
            int open = line.indexOf('['), close = line.lastIndexOf(']');
            if (line.isEmpty() || open < 0 || close < open) continue;
            names.add(line.substring(0, open).trim());
            String[] parts = line.substring(open + 1, close).split(",");
            int[] marks = new int[parts.length];
            for (int j = 0; j < parts.length; j++) marks[j] = Integer.parseInt(parts[j].trim());
            rows.add(marks);
        }
        if (rows.isEmpty()) return;

        int[][] grid = rows.toArray(new int[0][]);
        int subjects = grid[0].length;

        // totals per student + topper (first one wins ties)
        int[] totals = new int[grid.length];
        int top = 0;
        for (int s = 0; s < grid.length; s++) {
            for (int m : grid[s]) totals[s] += m;
            if (totals[s] > totals[top]) top = s;
        }
        // average per subject (column sums)
        double[] sums = new double[subjects];
        for (int[] row : grid) for (int c = 0; c < subjects; c++) sums[c] += row[c];

        StringJoiner tj = new StringJoiner(", ");
        for (int s = 0; s < grid.length; s++) tj.add(names.get(s) + " " + totals[s]);
        StringJoiner aj = new StringJoiner(", ");
        for (int c = 0; c < subjects; c++) aj.add(String.format(Locale.US, "%.2f", sums[c] / grid.length));

        System.out.println("Totals " + tj);
        System.out.println("averages " + aj);
        System.out.println("topper " + names.get(top) + " (" + totals[top] + ")");
    }
}
