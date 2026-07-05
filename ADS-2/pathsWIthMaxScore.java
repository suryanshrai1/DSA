import java.util.List;

public class pathsWIthMaxScore {
        int[][] dir = new int[][] { { -1, 0 }, { -1, -1 }, { 0, -1 } };
    int mod = (int) (1e9) + 7;
    Integer[][][] dp;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        dp = new Integer[n][n][2];

        int[] result = dfs(n - 1, n - 1, board);

        if (result[0] == -1) {
            return new int[] { 0, 0 };
        }

        return result;
    }

    public int[] dfs(int i, int j, List<String> arr) {
        if (i == 0 && j == 0) {
            return new int[] { 0, 1 };
        }

        if (dp[i][j][0] != null) {
            return new int[] { dp[i][j][0], dp[i][j][1] };
        }

        int maxScore = -1;
        int ways = 0;

        for (int[] r : dir) {
            int x = r[0] + i;
            int y = r[1] + j;

            if (x >= 0 && y >= 0 && x < arr.size() && y < arr.size() && arr.get(x).charAt(y) != 'X') {
                int[] next = dfs(x, y, arr);

                if (next[0] != -1) {
                    if (next[0] > maxScore) {
                        maxScore = next[0];
                        ways = next[1];
                    } else if (next[0] == maxScore) {
                        ways = (ways + next[1]) % mod;
                    }
                }
            }
        }

        if (maxScore != -1) {
            char currentCell = arr.get(i).charAt(j);
            int val = Character.isDigit(currentCell) ? currentCell - '0' : 0;
            maxScore += val;
        }

        dp[i][j][0] = maxScore;
        dp[i][j][1] = ways;

        return new int[] { maxScore, ways };
    }
}
