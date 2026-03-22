import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    public int orangesRot(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;

        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Find all initial rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If no fresh oranges initially, time required is 0
        if (freshOranges == 0) return 0;

        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean didRot = false;

            for (int k = 0; k < size; k++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];

                // Check all 4 adjacent cells
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // If the adjacent cell is a fresh orange, rot it and add to queue
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && mat[nr][nc] == 1) {
                        mat[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                        freshOranges--;
                        didRot = true;
                    }
                }
            }
            if (didRot) {
                minutes++;
            }
        }
        return (freshOranges == 0) ? minutes : -1;
    }
}