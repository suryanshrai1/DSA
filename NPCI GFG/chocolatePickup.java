public class chocolatePickup {
    public int maxChocolate(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        // dp[r][c1][c2] stores the max chocolates from row r with robot 1 at c1 and robot 2 at c2
        int[][][] dp = new int[n][m][m];
        for (int r = 0; r < n; r++) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int c2 = 0; c2 < m; c2++) {
                    dp[r][c1][c2] = -1;
                }
            }
        }
        return solve(0, 0, m - 1, grid, dp);
    }

    private int solve(int r, int c1, int c2, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        // Base case: out of bounds
        if (c1 < 0 || c1 >= m || c2 < 0 || c2 >= m) {
            return (int) -1e9; // Return a very small value to indicate an invalid path
        }
        
        // Base case: reached bottom row
        if (r == n - 1) {
            if (c1 == c2) {
                return grid[r][c1];
            } else {
                return grid[r][c1] + grid[r][c2];
            }
        }

        // Check if already computed
        if (dp[r][c1][c2] != -1) {
            return dp[r][c1][c2];
        }

        // Calculate chocolates collected in current step
        int currentChocolates;
        if (c1 == c2) {
            currentChocolates = grid[r][c1];
        } else {
            currentChocolates = grid[r][c1] + grid[r][c2];
        }

        // Recurse for all 9 possible next moves
        int maxNext = (int) -1e9;
        for (int dc1 = -1; dc1 <= 1; dc1++) {
            for (int dc2 = -1; dc2 <= 1; dc2++) {
                maxNext = Math.max(maxNext, solve(r + 1, c1 + dc1, c2 + dc2, grid, dp));
            }
        }
        return dp[r][c1][c2] = currentChocolates + maxNext;
    }
}