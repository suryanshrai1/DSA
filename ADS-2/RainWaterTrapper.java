import java.util.PriorityQueue;

public class RainWaterTrapper {

    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length, m = heightMap[0].length;
        int water = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        boolean[][] vis = new boolean[n][m];

        // Add border cells to priority queue
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][m - 1], i, m - 1});
            vis[i][0] = true;
            vis[i][m - 1] = true;
        }
        for (int i = 1; i < m - 1; i++) {
            pq.offer(new int[]{heightMap[0][i], 0, i});
            pq.offer(new int[]{heightMap[n - 1][i], n - 1, i});
            vis[0][i] = true;
            vis[n - 1][i] = true;
        }

        // Directions for traversal
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // Process cells in priority queue
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            for (int i = 0; i < 4; i++) {
                int x = cell[1] + dx[i];
                int y = cell[2] + dy[i];
                if (isValid(x, y, n, m) && !vis[x][y]) {
                    water += Math.max(0, cell[0] - heightMap[x][y]);
                    pq.offer(new int[]{Math.max(cell[0], heightMap[x][y]), x, y});
                    vis[x][y] = true;
                }
            }
        }

        return water;
    }

    public static void main(String[] args) {
        RainWaterTrapper solver = new RainWaterTrapper();

        int[][] heightMap = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };

        int result = solver.trapRainWater(heightMap);
        System.out.println("Trapped Rain Water: " + result);
    }
}
