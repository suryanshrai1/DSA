import java.util.ArrayList;

public class ratMazeWithMultiJumps {
     private int[][] dp;
    private int[][] sol;
    private int n;

    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        n = mat.length;
        sol = new int[n][n];
        dp = new int[n][n];

        if (dfs(mat, 0, 0)) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(sol[i][j]);
                }
                result.add(row);
            }
            return result;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(-1);
        ans.add(row);
        return ans;
    }

    private boolean dfs(int[][] mat, int r, int c) {
        if (r >= n || c >= n || mat[r][c] == 0)
            return false;

        if (r == n - 1 && c == n - 1) {
            sol[r][c] = 1;
            return true;
        }

        if (dp[r][c] == -1)
            return false;

        sol[r][c] = 1;

        int jumpLimit = mat[r][c];

        for (int jump = 1; jump <= jumpLimit; jump++) {

            // Move Right
            if (dfs(mat, r, c + jump))
                return true;

            // Move Down
            if (dfs(mat, r + jump, c))
                return true;
        }

        sol[r][c] = 0;
        dp[r][c] = -1;

        return false;
    }
}
