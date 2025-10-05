import java.util.*;

public class WaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights, Integer.MIN_VALUE);
            dfs(i, n - 1, atlantic, heights, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, heights, Integer.MIN_VALUE);
            dfs(m - 1, j, atlantic, heights, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, boolean[][] visited, int[][] heights, int prevHeight) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length)
            return;
        if (visited[i][j])
            return;
        if (heights[i][j] < prevHeight)
            return;

        visited[i][j] = true;
        dfs(i + 1, j, visited, heights, heights[i][j]);
        dfs(i - 1, j, visited, heights, heights[i][j]);
        dfs(i, j + 1, visited, heights, heights[i][j]);
        dfs(i, j - 1, visited, heights, heights[i][j]);
    }

    public static void main(String[] args) {
        WaterFlow solution = new WaterFlow();
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        List<List<Integer>> result = solution.pacificAtlantic(heights);

        System.out.println("Cells where water can flow to both the Pacific and Atlantic oceans:");
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }
}
