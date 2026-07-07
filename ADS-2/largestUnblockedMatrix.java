import java.util.Arrays;

public class largestUnblockedMatrix {
        public int largestArea(int n, int m, int[][] arr) {
        int k = arr.length;
        
        int[] rows = new int[k];
        int[] cols = new int[k];
        
        for (int i = 0; i < k; i++) {
            rows[i] = arr[i][0];
            cols[i] = arr[i][1];
        }
        
        Arrays.sort(rows);
        Arrays.sort(cols);
        
        int maxRows = maxGap(rows, n);
        int maxCols = maxGap(cols, m);
        
        return maxRows * maxCols;
    }
    
    private int maxGap(int[] arr, int limit) {
        int prev = 0;
        int best = 0;
        
        for (int x : arr) {
            best = Math.max(best, x - prev - 1);
            prev = x;
        }
        
        best = Math.max(best, limit - prev);
        return best;
    }
}
