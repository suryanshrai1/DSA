import java.util.*;

public class TrapezoidCounter {

    public int countTrapezoids(int[][] points) {
        long MOD = 1_000_000_007L;

        // Count number of points with each Y-coordinate
        HashMap<Integer, Long> map = new HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0L) + 1);
        }

        // For every y-level with k points, number of segments = C(k,2)
        ArrayList<Long> seg = new ArrayList<>();
        for (long k : map.values()) {
            if (k >= 2) {
                seg.add((k * (k - 1) / 2) % MOD);
            }
        }

        // Count pairs of segments on different Y-levels
        long sum = 0, ans = 0;
        for (long v : seg) {
            ans = (ans + v * sum) % MOD;
            sum = (sum + v) % MOD;
        }

        return (int) ans;
    }

    // -------------------- MAIN METHOD --------------------
    public static void main(String[] args) {
        TrapezoidCounter tc = new TrapezoidCounter();

        // Example input:
        int[][] points = {
            {1, 2},
            {2, 2},
            {5, 4},
            {6, 4},
            {10, 4}
        };

        int result = tc.countTrapezoids(points);
        System.out.println("Number of trapezoids: " + result);
    }
}
