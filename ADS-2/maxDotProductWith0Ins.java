public class maxDotProductWith0Ins{
        public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        // dp[i][j] stores the max dot product using first i elements of a and j elements of b
        int[][] dp = new int[n + 1][m + 1];

        for (int j = 1; j <= m; j++) {
            for (int i = j; i <= n; i++) {
                // Option 1: Match a[i-1] with b[j-1]
                int take = a[i - 1] * b[j - 1] + dp[i - 1][j - 1];
                
                // Option 2: Skip a[i-1] (multiply it by 0)
                int skip = dp[i - 1][j];
                
                // We take the max, but if i == j, we MUST take the current pair 
                // because we need all elements of b to be used.
                if (i == j) {
                    dp[i][j] = take;
                } else {
                    dp[i][j] = Math.max(take, skip);
                }
            }
        }
        return dp[n][m];
    }
}
