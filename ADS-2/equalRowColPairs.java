import java.util.*;

public class equalRowColPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        Map<List<Integer>, Integer> map = new HashMap<>();

        //storing rows
        for (int r = 0; r < n; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                row.add(grid[r][c]);
            }
            map.put(row, map.getOrDefault(row, 0)+1);
        }
        // matching with columns
        for(int c=0;c<n;c++){
            List<Integer> col = new ArrayList<>();
            for(int r=0;r<n;r++){
                col.add(grid[r][c]);
            }
            ans+= map.getOrDefault(col, 0);
        }
        return ans;
    }
}