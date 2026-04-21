public class twoWaterJug {
    public int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n)) return -1;
        if (d % gcd(m, n) != 0) return -1;
        
        return Math.min(pour(m, n, d), pour(n, m, d));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int pour(int fromCap, int toCap, int target) {
        int from = fromCap;
        int to = 0;
        int steps = 1;

        while (from != target && to != target) {
            int temp = Math.min(from, toCap - to);

            to += temp;
            from -= temp;
            steps++;

            if (from == target || to == target) break;

            if (from == 0) {
                from = fromCap;
                steps++;
            }

            if (to == toCap) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }
}