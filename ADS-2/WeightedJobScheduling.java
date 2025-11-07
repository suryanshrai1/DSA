import java.util.*;

public class WeightedJobScheduling {

    // Function to find the maximum profit
    public int maxProfit(int[][] jobs) {
        // Step 1: Sort jobs by end time
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0][2]; // Base case

        for (int i = 1; i < n; i++) {
            int includeProfit = jobs[i][2];

            // Step 2: Binary search for the last non-overlapping job
            int l = 0, r = i - 1;
            int lastNonOverlap = -1;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (jobs[mid][1] <= jobs[i][0]) {
                    lastNonOverlap = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if (lastNonOverlap != -1)
                includeProfit += dp[lastNonOverlap];

            // Step 3: Either include this job or skip it
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];
    }

    // Main method to test the solution
    public static void main(String[] args) {
        WeightedJobScheduling solver = new WeightedJobScheduling();

        int[][] jobs1 = {
            {1, 2, 50},
            {3, 5, 20},
            {6, 19, 100},
            {2, 100, 200}
        };
        System.out.println("Maximum Profit (Example 1): " + solver.maxProfit(jobs1)); 
        // Expected output: 250

        int[][] jobs2 = {
            {1, 3, 60},
            {2, 5, 50},
            {4, 6, 70},
            {5, 7, 30}
        };
        System.out.println("Maximum Profit (Example 2): " + solver.maxProfit(jobs2)); 
        // Expected output: 130
    }
}
