import java.util.ArrayList;
import java.util.List;

public class cyclicGridRotation {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            List<Integer> elem = new ArrayList<>();

            // Extracting elems of current layer

            // top row
            for (int c = left; c <= right; c++) {
                elem.add(grid[top][c]);
            }

            // right column
            for (int r = top + 1; r < bottom; r++) {
                elem.add(grid[r][right]);
            }

            // bottom row
            for (int c = right; c >= left; c--) {
                elem.add(grid[bottom][c]);
            }

            // left column
            for (int r = bottom - 1; r > top; r--) {
                elem.add(grid[r][left]);
            }

            int len = elem.size();
            int rot = k % len;

            int idx = 0;

            // Putting back rotated values directly using modular indexing
            // top row
            for (int c = left; c <= right; c++) {
                grid[top][c] = elem.get((idx + rot) % len);
                idx++;
            }

            // right column
            for (int r = top + 1; r < bottom; r++) {
                grid[r][right] = elem.get((idx + rot) % len);
                idx++;
            }

            // bottom row
            for (int c = right; c >= left; c--) {
                grid[bottom][c] = elem.get((idx + rot) % len);
                idx++;
            }

            // left column
            for (int r = bottom - 1; r > top; r--) {
                grid[r][left] = elem.get((idx + rot) % len);
                idx++;
            }
        }
        return grid;
    }
}
