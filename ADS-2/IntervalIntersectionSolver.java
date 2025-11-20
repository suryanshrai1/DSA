import java.util.Arrays;

public class IntervalIntersectionSolver {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
                a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int[] todo = new int[intervals.length];
        Arrays.fill(todo, 2);
        int ans = 0, t = intervals.length;

        while (--t >= 0) {
            int s = intervals[t][0];
            int e = intervals[t][1];
            int m = todo[t];
            for (int p = s; p < s + m; ++p) {
                for (int i = 0; i <= t; ++i)
                    if (todo[i] > 0 && p <= intervals[i][1])
                        todo[i]--;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        IntervalIntersectionSolver solver = new IntervalIntersectionSolver();

        // Example input
        int[][] intervals = {
                {1, 3},
                {3, 7},
                {2, 5},
                {1, 4}
        };

        int result = solver.intersectionSizeTwo(intervals);

        System.out.println("Minimum size of intersection set = " + result);
    }
}
