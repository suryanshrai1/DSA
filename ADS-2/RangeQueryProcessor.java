public class RangeQueryProcessor {
    
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];

        // Process each query
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            for (int i = r1; i <= r2; i++) {
                matrix[i][c1] += 1; // Start incrementing at the beginning of the range
                if (c2 + 1 < n) { // Only update the end if it's within bounds
                    matrix[i][c2 + 1] -= 1;
                }
            }
        }

        // Apply the row-wise prefix sum to compute the final result
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        RangeQueryProcessor processor = new RangeQueryProcessor();
        
        int n = 5; // Example size of the matrix
        int[][] queries = {
            {1, 1, 3, 3}, // Query to add 1 to the submatrix from (1, 1) to (3, 3)
            {2, 2, 4, 4}  // Query to add 1 to the submatrix from (2, 2) to (4, 4)
        };
        
        int[][] result = processor.rangeAddQueries(n, queries);
        
        // Print the resulting matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
