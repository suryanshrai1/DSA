public class towerReachingBothStations {
        public int countCoordinates(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        int rows = mat.length;
        int cols = mat[0].length;

        boolean[][] reachableP = new boolean[rows][cols];
        boolean[][] reachableQ = new boolean[rows][cols];

        // Start DFS from top and bottom boundaries
        for (int c = 0; c < cols; c++) {
            dfs(mat, 0, c, reachableP, mat[0][c]);
            dfs(mat, rows - 1, c, reachableQ, mat[rows - 1][c]);
        }

        // Start DFS from left and right boundaries
        for (int r = 0; r < rows; r++) {
            dfs(mat, r, 0, reachableP, mat[r][0]);
            dfs(mat, r, cols - 1, reachableQ, mat[r][cols - 1]);
        }

        // Count cells reachable by both stations
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (reachableP[r][c] && reachableQ[r][c]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] mat, int r, int c, boolean[][] reachable, int prevHeight) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Base cases: Out of bounds, already visited, or cannot flow uphill
        if (r < 0 || r >= rows || c < 0 || c >= cols || reachable[r][c] || mat[r][c] < prevHeight) {
            return;
        }

        reachable[r][c] = true;

        // Explore all 4 orthogonal directions
        dfs(mat, r + 1, c, reachable, mat[r][c]);
        dfs(mat, r - 1, c, reachable, mat[r][c]);
        dfs(mat, r, c + 1, reachable, mat[r][c]);
        dfs(mat, r, c - 1, reachable, mat[r][c]);
    }
}
