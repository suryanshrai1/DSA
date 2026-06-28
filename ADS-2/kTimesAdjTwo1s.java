public class kTimesAdjTwo1s {
        public int countStrings(int n, int k) {
        int MOD = 1000000007;
        // dp[length][count_of_pairs][last_digit]
        int[][][] dp = new int[n + 1][k + 1][2];

        // Base cases for length 1
        dp[1][0][0] = 1; // String "0"
        dp[1][0][1] = 1; // String "1"

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // Ending with 0: can follow either 0 or 1 from length i-1
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;

                // Ending with 1: 
                // 1. Follows a 0: j remains same
                dp[i][j][1] = dp[i - 1][j][0];
                // 2. Follows a 1: j increases by 1 (only if j > 0)
                if (j > 0) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j - 1][1]) % MOD;
                }
            }
        }
        return (dp[n][k][0] + dp[n][k][1]) % MOD;
    }
}
