import java.util.*;

public class TrapezoidCounter1 {

    public int countTrapezoids(int[][] points) {
        int n = points.length;
        double inf = 1e9 + 7;
        Map<Double, List<Double>> slopeToIntercept = new HashMap<>();
        Map<Integer, List<Double>> midToSlope = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x1 - x2;
                int dy = y1 - y2;
                double k;
                double b;

                if (x2 == x1) {
                    k = inf;
                    b = x1;
                } else {
                    k = (1.0 * (y2 - y1)) / (x2 - x1);
                    b = (1.0 * (y1 * dx - x1 * dy)) / dx;
                }

                if (k == -0.0) k = 0.0;
                if (b == -0.0) b = 0.0;

                int mid = (x1 + x2) * 10000 + (y1 + y2);

                slopeToIntercept
                        .computeIfAbsent(k, key -> new ArrayList<>())
                        .add(b);

                midToSlope
                        .computeIfAbsent(mid, key -> new ArrayList<>())
                        .add(k);
            }
        }

        // Count pairs with same slope & intercept
        for (List<Double> sti : slopeToIntercept.values()) {
            if (sti.size() == 1) continue;

            Map<Double, Integer> cnt = new TreeMap<>();
            for (double b : sti) {
                cnt.put(b, cnt.getOrDefault(b, 0) + 1);
            }
            int sum = 0;
            for (int count : cnt.values()) {
                ans += sum * count;
                sum += count;
            }
        }

        // Subtract where midpoints are the same (overcount fix)
        for (List<Double> mts : midToSlope.values()) {
            if (mts.size() == 1) continue;

            Map<Double, Integer> cnt = new TreeMap<>();
            for (double k : mts) {
                cnt.put(k, cnt.getOrDefault(k, 0) + 1);
            }
            int sum = 0;
            for (int count : cnt.values()) {
                ans -= sum * count;
                sum += count;
            }
        }

        return ans;
    }

    // ------------------ MAIN METHOD ------------------ //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // number of points
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        TrapezoidCounter1 tc = new TrapezoidCounter1();
        int result = tc.countTrapezoids(points);

        System.out.println(result);
        sc.close();
    }
}
