public class cutMatrix {
    static int mod = (int) 1e9 + 7;

    static int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Build suffix sum
        int[][] suf = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--)
                suf[i][j] = suf[i + 1][j] + suf[i][j + 1] - suf[i + 1][j + 1] + matrix[i][j];

        // dp[r][c][p] = ways to divide submatrix (r,c) into p pieces
        int[][][] dp = new int[n][m][k + 1];

        // Base case: 1 piece
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++)
                dp[r][c][1] = suf[r][c] > 0 ? 1 : 0;

        for (int p = 2; p <= k; p++) {

            // Suffix sum of dp values over rows for each column
            int[][] sufRow = new int[n + 1][m];
            for (int c = 0; c < m; c++)
                for (int r = n - 1; r >= 0; r--)
                    sufRow[r][c] = (sufRow[r + 1][c] + dp[r][c][p - 1]) % mod;

            // Suffix sum of dp values over cols for each row
            int[][] sufCol = new int[n][m + 1];
            for (int r = 0; r < n; r++)
                for (int c = m - 1; c >= 0; c--)
                    sufCol[r][c] = (sufCol[r][c + 1] + dp[r][c][p - 1]) % mod;

            for (int r = n - 1; r >= 0; r--) {
                for (int c = m - 1; c >= 0; c--) {
                    if (suf[r][c] == 0)
                        continue;
                    int res = 0;

                    // Binary search first row where top strip has at least one 1
                    int lo = r + 1, hi = n;
                    while (lo < hi) {
                        int mid = (lo + hi) / 2;
                        if (suf[mid][c] < suf[r][c])
                            hi = mid;
                        else
                            lo = mid + 1;
                    }
                    if (lo < n)
                        res = (res + sufRow[lo][c]) % mod;

                    // Binary search first col where left strip has at least one 1
                    int lo2 = c + 1, hi2 = m;
                    while (lo2 < hi2) {
                        int mid = (lo2 + hi2) / 2;
                        if (suf[r][mid] < suf[r][c])
                            hi2 = mid;
                        else
                            lo2 = mid + 1;
                    }
                    if (lo2 < m)
                        res = (res + sufCol[r][lo2]) % mod;

                    dp[r][c][p] = res;
                }
            }
        }
        return dp[0][0][k];
    }

    public static void main(String[] args) {
        System.out.println(findWays(new int[][] { { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 } }, 3));
    }
}
