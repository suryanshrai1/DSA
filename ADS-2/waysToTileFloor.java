import java.util.Arrays;

public class waysToTileFloor {
        static final int MOD = 1000000007;
    int[] dp;

    int solve(int n, int m) {
        if (n < m) return 1;
        if (n == m) return 2;

        if (dp[n] != -1) return dp[n];

        return dp[n] = (int)(((long)solve(n - 1, m) + solve(n - m, m)) % MOD);
    }

    public int countWays(int n, int m) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, m);
    }
}
