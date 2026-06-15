import java.util.Arrays;

public class minCostToFillWt {
        public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int[] dp = new int[w + 1];
        
        int INF = 100000000; 
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            if (cost[j - 1] != -1) {
                for (int i = j; i <= w; i++) {
                    if (dp[i - j] != INF) {
                        dp[i] = Math.min(dp[i], dp[i - j] + cost[j - 1]);
                    }
                }
            }
        }

        return (dp[w] == INF) ? -1 : dp[w];
    }
}
